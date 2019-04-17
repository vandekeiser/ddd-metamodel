package fr.cla.ddd.metamodel.exampleapp.infra.equatability.sameruntimeclass;

import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcConference;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcTalk;
import fr.cla.ddd.metamodel.exampleapp.infra.JpaConfig;
import fr.cla.ddd.oo.Equatable;
import org.hibernate.proxy.HibernateProxy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TestTransaction;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
@DataJpaTest
@ContextConfiguration(classes = JpaConfig.class)
public class SdjSrcConferencesTest {

    @Autowired private SdjSrcConferences sut;
    @Autowired private SrcConferencesSdj sdj;

    @Test
    public void should_find_persisted_entity() {
        SrcConference conf;

        given: {
            conf = scheduleConference();
            assertThat(
                sut.get(conf.getId())
            ).isEmpty();
        }

        when: {
            sut.add(conf);
        }

        then: {
            assertThat(
                sut.get(conf.getId())
            ).isEqualTo(
                Optional.of(conf)
            );
        }
    }

    @Test
    public void reloaded_talk_should_be_equal_to_persisted_talk() {
        SrcConference persistedConf, reloadedConf;
        SrcTalk persistedTalk, reloadedTalk;

        given: {
            persistedConf = scheduleConference();
            persistedTalk = getSingleTalk(persistedConf);
            assertThat(
                sut.get(persistedConf.getId())
            ).isEmpty();
        }

        when: {
            sut.add(persistedConf);
        }

        then: {
            reloadedConf = sut.get(persistedConf.getId()).get();
            assertThat(reloadedConf).isEqualTo(persistedConf);
        }

        then: {
            reloadedTalk = getSingleTalk(reloadedConf);
            assertThat(reloadedTalk).isEqualTo(persistedTalk);
        }
    }

    @Test
    public void reloaded_lazy_proxy_cant_be_equal() {
        reloaded_lazy_proxy_conference_should_be_equal_to_persisted_conference(
            false
        );
    }

    private void reloaded_lazy_proxy_conference_should_be_equal_to_persisted_conference(
        boolean expectedEquals
    ) {
        SrcConference persistedConf = scheduleConference();

        given: {
            doInAnotherTransaction(() -> sut.add(persistedConf));
        }

        doInAnotherTransaction( () -> {
            SrcConference lazyProxy;

            when: {
                lazyProxy = loadLazyProxy(persistedConf.getId());
            }

            then: {
                //It's not the same...
                assertThat(lazyProxy).isNotSameAs(persistedConf);
                assertThat(lazyProxy.getClass()).isNotEqualTo(persistedConf.getClass());
                //...but it's equal
                if(expectedEquals) {
                    assertThat(lazyProxy).isEqualTo(persistedConf);
                } else {
                    assertThat(lazyProxy).isNotEqualTo(persistedConf);
                }

            }
        });
    }

    private SrcConference loadLazyProxy(ConferenceId id) {
        SrcConference reloadedConf = sdj.getOne(id);

        //Sanity check that it is really a lazy proxy
        assertThat(reloadedConf instanceof HibernateProxy).isTrue();

        //Check that, because it doesn't work when getId() is final
        assertThat(reloadedConf.getId()).isEqualTo(id);

        return reloadedConf;
    }

    private void doInAnotherTransaction(Runnable task) {
        if(TestTransaction.isActive()) {
            TestTransaction.end();
        }

        TestTransaction.start();
        try {
            task.run();
            TestTransaction.flagForCommit();
        } catch (Throwable t) {
            TestTransaction.flagForRollback();
            throw new AssertionError(t);
        } finally {
            TestTransaction.end();
        }
    }

    private SrcTalk getSingleTalk(SrcConference conf) {
        if (conf.getTalks().size() != 1) throw new IllegalArgumentException();
        return conf.getTalks().iterator().next();
    }

    private SrcConference scheduleConference() {
        return new SrcConference(
            new ConferenceId(),
            new MonetaryAmount(1000),
            new SrcTalk(new MonetaryAmount(100))
        );
    }

}
//@formatter:on
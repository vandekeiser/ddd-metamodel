package fr.cla.ddd.metamodel.exampleapp.infra.equatability.samedeclaredclass;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredclass.SdcConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredclass.SdcTalk;
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
public class SdjSdcConferencesTest {

    @Autowired private SdjSdcConferences sut;
    @Autowired private SdcConferencesSdj sdj;

    @Test
    public void should_find_persisted_entity() {
        SdcConference conf;

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
        SdcConference persistedConf, reloadedConf;
        SdcTalk persistedTalk, reloadedTalk;

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
    public void reloaded_lazy_proxy_should_be_equal() {
        reloaded_lazy_proxy_should_be_equal(true);
    }

    private void reloaded_lazy_proxy_should_be_equal(
        boolean expectedEquals
    ) {
        SdcConference persistedConf = scheduleConference();

        given: {
            doInAnotherTransaction(() -> sut.add(persistedConf));
        }

        doInAnotherTransaction( () -> {
            SdcConference lazyProxy;

            when: {
                lazyProxy = loadLazyProxy(persistedConf.getId());
            }

            then: {
                //It's not the same...
                assertThat(lazyProxy).isNotSameAs(persistedConf);
                assertThat(lazyProxy.getClass()).isNotEqualTo(persistedConf.getClass());

                if(expectedEquals) {
                    assertThat(lazyProxy).isEqualTo(persistedConf);
                } else {
                    assertThat(lazyProxy).isNotEqualTo(persistedConf);
                }

            }
        });
    }

    private SdcConference loadLazyProxy(ConferenceId id) {
        SdcConference reloadedConf = sdj.getOne(id);

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

    private SdcTalk getSingleTalk(SdcConference conf) {
        if (conf.getTalks().size() != 1) throw new IllegalArgumentException();
        return conf.getTalks().iterator().next();
    }

    private SdcConference scheduleConference() {
        return new SdcConference(
            new ConferenceId(),
            new MonetaryAmount(1000),
            new SdcTalk(new MonetaryAmount(100))
        );
    }

}
//@formatter:on
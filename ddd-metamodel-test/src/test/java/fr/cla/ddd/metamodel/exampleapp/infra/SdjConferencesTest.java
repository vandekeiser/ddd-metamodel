package fr.cla.ddd.metamodel.exampleapp.infra;

import fr.cla.ddd.metamodel.exampleapp.domain.Conference;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.Talk;
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
public class SdjConferencesTest {

    @Autowired private SdjConferences sut;
    @Autowired private ConferencesSdj sdj;
    //    @Autowired private SessionFactory sessFactory;
//    private Session sess;
    //@PersistenceContext private EntityManager em;
    //@PersistenceUnit private EntityManagerFactory emf;
//    @Autowired private SdjEm sdjEm;

    @Test
    public void should_find_persisted_entity() {
        Conference conf;

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
        Conference persistedConf, reloadedConf;
        Talk persistedTalk, reloadedTalk;

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
    public void reloaded_lazy_proxy_conference_should_be_equal_to_persisted_conference() {
        Conference persistedConf = scheduleConference();

        given: {
            doInAnotherTransaction(() -> sut.add(persistedConf));
        }

        doInAnotherTransaction( () -> {
            Conference lazyProxy;

            when: {
                lazyProxy = loadLazyProxy(persistedConf.getId());
            }

            then: {
                //It's not the same...
                assertThat(lazyProxy).isNotSameAs(persistedConf);
                assertThat(lazyProxy.getClass()).isNotEqualTo(persistedConf.getClass());
                //...but it's equal
                assertThat(lazyProxy).isEqualTo(persistedConf);
            }
        });
    }

    private Conference loadLazyProxy(ConferenceId id) {
        Conference reloadedConf = sdj.getOne(id);

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
        } finally {
            TestTransaction.end();
        }
    }

    private Talk getSingleTalk(Conference conf) {
        if (conf.getTalks().size() != 1) throw new IllegalArgumentException();
        return conf.getTalks().iterator().next();
    }

    private Conference scheduleConference() {
        return new Conference(
            new ConferenceId(),
            new MonetaryAmount(1000),
            new Talk(new MonetaryAmount(100))
        );
    }

}
//@formatter:on
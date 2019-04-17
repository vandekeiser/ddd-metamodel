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

import javax.persistence.EntityManager;
import java.util.Optional;

import static java.lang.System.out;
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
    public void xxxxxxxxx4() {//TODO eqh
        Conference persistedConf;
//        EntityManager em = sdjEm.get(Conference.class);

        given: {
            persistedConf = scheduleConference();
            doInAnotherTransaction_TestTransaction(() -> sut.add(persistedConf));
//            sut.add(persistedConf);
//            em.detach(persistedConf);
        }

        doInAnotherTransaction_TestTransaction( () -> {
            Conference reloadedConf;

            given:
            {
                out.println("________persistedConf.id(): " + persistedConf.getId());
                reloadedConf = sdj.getOne(persistedConf.getId());
                assertThat(reloadedConf instanceof HibernateProxy).isTrue();
                out.println("________reloadedConf.getClass(): " + reloadedConf.getClass());
                out.println();
                out.println("________reloadedConf.id(): " + reloadedConf.getId());
                out.println("________reloadedConf.toString(): " + reloadedConf.toString());
                out.println();
                out.println("________reloadedConf.id(): " + reloadedConf.getId());
                out.println("________reloadedConf.toString(): " + reloadedConf.toString());
//                reloadedConf.id();
//                reloadedConf.id();
//                reloadedConf.toString();
//                reloadedConf.toString();
                assertThat(reloadedConf.getId()).isEqualTo(persistedConf.getId());
//            reloadedConf = sdj.getOne(new ConferenceId(UUID.randomUUID().toString()));

            }

            when_then:
            {
                assertThat(reloadedConf).isNotSameAs(persistedConf);
                persistedConf.getTalks().forEach(out::println);
                assertThat(reloadedConf).isEqualTo(persistedConf);
            }
        });
    }

    private void doInAnotherTransaction_TestTransaction(Runnable task) {
        if(TestTransaction.isActive()) {
            TestTransaction.end();
        }
        TestTransaction.start();

        task.run();

        TestTransaction.flagForCommit();
        TestTransaction.end();
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
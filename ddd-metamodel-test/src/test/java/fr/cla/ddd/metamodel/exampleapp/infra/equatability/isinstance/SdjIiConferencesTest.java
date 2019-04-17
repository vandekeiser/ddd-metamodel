package fr.cla.ddd.metamodel.exampleapp.infra.equatability.isinstance;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance.IiConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance.IiTalk;
import fr.cla.ddd.metamodel.exampleapp.infra.JpaConfig;
import fr.cla.ddd.metamodel.exampleapp.infra.equatability.AbstractSdjConferencesTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
@DataJpaTest
@ContextConfiguration(classes = JpaConfig.class)
public class SdjIiConferencesTest
extends AbstractSdjConferencesTest<IiConference> {

    @Autowired private SdjIiConferences sut;
    @Autowired private IiConferencesSdj sdj;

    @Test
    public void should_find_persisted_entity() {
        IiConference conf;

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
        IiConference persistedConf, reloadedConf;
        IiTalk persistedTalk, reloadedTalk;

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

    private IiTalk getSingleTalk(IiConference conf) {
        if (conf.getTalks().size() != 1) throw new IllegalArgumentException();
        return conf.getTalks().iterator().next();
    }

    private IiConference scheduleConference() {
        return new IiConference(
            new ConferenceId(),
            new MonetaryAmount(1000),
            new IiTalk(new MonetaryAmount(100))
        );
    }

    @Override
    protected boolean doesEqualWorkWithProxies() {
        return true;
    }

    @Override
    protected IiConference addConference() {
        IiConference conf = scheduleConference();
        sut.add(conf);
        return conf;
    }

    @Override
    protected IiConference loadLazyProxyFor(ConferenceId id) {
        return sdj.getOne(id);
    }

}
//@formatter:on
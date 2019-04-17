package fr.cla.ddd.metamodel.exampleapp.infra.equatability.canequal;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal.CeConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal.CeTalk;
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
public class SdjCeConferencesTest
extends AbstractSdjConferencesTest<CeConference> {

    @Autowired private SdjCeConferences sut;
    @Autowired private CeConferencesSdj sdj;

    @Test
    public void reloaded_talk_should_be_equal_to_persisted_talk() {
        CeConference persistedConf, reloadedConf;
        CeTalk persistedTalk, reloadedTalk;

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

    private CeTalk getSingleTalk(CeConference conf) {
        if (conf.getTalks().size() != 1) throw new IllegalArgumentException();
        return conf.getTalks().iterator().next();
    }

    @Override
    protected boolean doesEqualWorkWithProxies() {
        return true;
    }

    @Override
    protected CeConference scheduleAndAddConference() {
        CeConference conf = scheduleConference();
        sut.add(conf);
        return conf;
    }
    @Override
    protected CeConference scheduleConference() {
        return new CeConference(
            new ConferenceId(),
            new MonetaryAmount(1000),
            new CeTalk(new MonetaryAmount(100))
        );
    }
    @Override
    protected void add(CeConference conf) {
        sut.add(conf);
    }

    @Override
    protected Optional<CeConference> get(ConferenceId id) {
        return sut.get(id);
    }
    @Override
    protected CeConference loadLazyProxyFor(ConferenceId id) {
        return sdj.getOne(id);
    }
}
//@formatter:on
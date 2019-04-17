package fr.cla.ddd.metamodel.exampleapp.infra.equatability.canequal;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal.CeConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal.CeTalk;
import fr.cla.ddd.metamodel.exampleapp.infra.JpaConfig;
import fr.cla.ddd.metamodel.exampleapp.infra.equatability.AbstractSdjConferencesTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

//@formatter:off
@DataJpaTest
@ContextConfiguration(classes = JpaConfig.class)
public class SdjCeConferencesTest
extends AbstractSdjConferencesTest<CeConference, CeTalk> {

    @Autowired private SdjCeConferences sut;
    @Autowired private CeConferencesSdj sdj;

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

    @Override
    protected CeTalk getSingleTalk(CeConference conf) {
        if (conf.getTalks().size() != 1) throw new IllegalArgumentException();
        return conf.getTalks().iterator().next();
    }
}
//@formatter:on
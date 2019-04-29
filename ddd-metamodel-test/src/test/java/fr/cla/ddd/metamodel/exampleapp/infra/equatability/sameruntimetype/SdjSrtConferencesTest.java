package fr.cla.ddd.metamodel.exampleapp.infra.equatability.sameruntimetype;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtTalk;
import fr.cla.ddd.metamodel.exampleapp.infra.JpaConfig;
import fr.cla.ddd.metamodel.exampleapp.infra.equatability.AbstractSdjConferencesTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;


@DataJpaTest
@ContextConfiguration(classes = JpaConfig.class)
public class SdjSrtConferencesTest
extends AbstractSdjConferencesTest<SrtConference, SrtTalk> {

    @Autowired private SdjSrtConferences sut;
    @Autowired private SrtConferencesSdj sdj;

    @Override
    protected boolean doesEqualWorkWithProxyClasses() {
        return false;
    }

    @Override
    protected SrtConference scheduleConference() {
        return new SrtConference(
            new ConferenceId(),
            new MonetaryAmount(1000),
            new SrtTalk(new MonetaryAmount(100))
        );
    }
    @Override
    protected void add(SrtConference conf) {
        sut.add(conf);
    }

    @Override
    protected Optional<SrtConference> get(ConferenceId id) {
        return sut.get(id);
    }
    @Override
    protected SrtConference loadLazyProxyFor(ConferenceId id) {
        return sdj.getOne(id);
    }

    @Override
    protected SrtTalk getSingleTalk(SrtConference conf) {
        if (conf.getTalks().size() != 1) throw new IllegalArgumentException();
        return conf.getTalks().iterator().next();
    }

}

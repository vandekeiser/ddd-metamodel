package fr.cla.ddd.metamodel.exampleapp.infra.jpa.equatability.samedeclaredtype;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredtype.SdtConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredtype.SdtTalk;
import fr.cla.ddd.metamodel.exampleapp.infra.jpa.JpaConfig;
import fr.cla.ddd.metamodel.exampleapp.infra.jpa.equatability.AbstractSdjConferencesTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;


@DataJpaTest
@ContextConfiguration(classes = JpaConfig.class)
public class SdjSdtConferencesTest
extends AbstractSdjConferencesTest<SdtConference, SdtTalk> {

    @Autowired private SdjSdtConferences sut;
    @Autowired private SdtConferencesSdj sdj;

    @Override
    protected boolean doesEqualWorkWithProxyClasses() {
        return true;
    }

    @Override
    protected SdtConference scheduleConference() {
        return new SdtConference(
            new ConferenceId(),
            new MonetaryAmount(1000),
            new SdtTalk(new MonetaryAmount(100))
        );
    }
    @Override
    protected void add(SdtConference conf) {
        sut.add(conf);
    }

    @Override
    protected Optional<SdtConference> get(ConferenceId id) {
        return sut.get(id);
    }
    @Override
    protected SdtConference loadLazyProxyFor(ConferenceId id) {
        return sdj.getOne(id);
    }

    @Override
    protected SdtTalk getSingleTalk(SdtConference conf) {
        if (conf.getTalks().size() != 1) throw new IllegalArgumentException();
        return conf.getTalks().iterator().next();
    }

}

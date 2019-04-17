package fr.cla.ddd.metamodel.exampleapp.infra.equatability.samedeclaredclass;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredclass.SdcConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredclass.SdcTalk;
import fr.cla.ddd.metamodel.exampleapp.infra.JpaConfig;
import fr.cla.ddd.metamodel.exampleapp.infra.equatability.AbstractSdjConferencesTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

//@formatter:off
@DataJpaTest
@ContextConfiguration(classes = JpaConfig.class)
public class SdjSdcConferencesTest
extends AbstractSdjConferencesTest<SdcConference, SdcTalk> {

    @Autowired private SdjSdcConferences sut;
    @Autowired private SdcConferencesSdj sdj;

    @Override
    protected boolean doesEqualWorkWithProxyClasses() {
        return true;
    }

    @Override
    protected SdcConference scheduleConference() {
        return new SdcConference(
            new ConferenceId(),
            new MonetaryAmount(1000),
            new SdcTalk(new MonetaryAmount(100))
        );
    }
    @Override
    protected void add(SdcConference conf) {
        sut.add(conf);
    }

    @Override
    protected Optional<SdcConference> get(ConferenceId id) {
        return sut.get(id);
    }
    @Override
    protected SdcConference loadLazyProxyFor(ConferenceId id) {
        return sdj.getOne(id);
    }

    @Override
    protected SdcTalk getSingleTalk(SdcConference conf) {
        if (conf.getTalks().size() != 1) throw new IllegalArgumentException();
        return conf.getTalks().iterator().next();
    }

}
//@formatter:on
package fr.cla.ddd.metamodel.exampleapp.infra.equatability.sameruntimeclass;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcTalk;
import fr.cla.ddd.metamodel.exampleapp.infra.JpaConfig;
import fr.cla.ddd.metamodel.exampleapp.infra.equatability.AbstractSdjConferencesTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

//@formatter:off
@DataJpaTest
@ContextConfiguration(classes = JpaConfig.class)
public class SdjSrcConferencesTest
extends AbstractSdjConferencesTest<SrcConference, SrcTalk> {

    @Autowired private SdjSrcConferences sut;
    @Autowired private SrcConferencesSdj sdj;

    @Override
    protected boolean doesEqualWorkWithProxies() {
        return false;
    }

    @Override
    protected SrcConference scheduleAndAddConference() {
        SrcConference conf = scheduleConference();
        sut.add(conf);
        return conf;
    }
    @Override
    protected SrcConference scheduleConference() {
        return new SrcConference(
            new ConferenceId(),
            new MonetaryAmount(1000),
            new SrcTalk(new MonetaryAmount(100))
        );
    }
    @Override
    protected void add(SrcConference conf) {
        sut.add(conf);
    }

    @Override
    protected Optional<SrcConference> get(ConferenceId id) {
        return sut.get(id);
    }
    @Override
    protected SrcConference loadLazyProxyFor(ConferenceId id) {
        return sdj.getOne(id);
    }

    @Override
    protected SrcTalk getSingleTalk(SrcConference conf) {
        if (conf.getTalks().size() != 1) throw new IllegalArgumentException();
        return conf.getTalks().iterator().next();
    }

}
//@formatter:on
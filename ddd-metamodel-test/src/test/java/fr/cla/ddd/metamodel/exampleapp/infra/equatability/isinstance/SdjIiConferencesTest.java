package fr.cla.ddd.metamodel.exampleapp.infra.equatability.isinstance;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance.IiConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance.IiTalk;
import fr.cla.ddd.metamodel.exampleapp.infra.JpaConfig;
import fr.cla.ddd.metamodel.exampleapp.infra.equatability.AbstractSdjConferencesTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

//@formatter:off
@DataJpaTest
@ContextConfiguration(classes = JpaConfig.class)
public class SdjIiConferencesTest
extends AbstractSdjConferencesTest<IiConference, IiTalk> {

    @Autowired private SdjIiConferences sut;
    @Autowired private IiConferencesSdj sdj;

    @Override
    protected boolean doesEqualWorkWithProxyClasses() {
        return true;
    }

    @Override
    protected IiConference scheduleConference() {
        return new IiConference(
            new ConferenceId(),
            new MonetaryAmount(1000),
            new IiTalk(new MonetaryAmount(100))
        );
    }
    @Override
    protected void add(IiConference conf) {
        sut.add(conf);
    }

    @Override
    protected Optional<IiConference> get(ConferenceId id) {
        return sut.get(id);
    }

    @Override
    protected IiConference loadLazyProxyFor(ConferenceId id) {
        return sdj.getOne(id);
    }

    @Override
    protected IiTalk getSingleTalk(IiConference conf) {
        if (conf.getTalks().size() != 1) throw new IllegalArgumentException();
        return conf.getTalks().iterator().next();
    }

}
//@formatter:on
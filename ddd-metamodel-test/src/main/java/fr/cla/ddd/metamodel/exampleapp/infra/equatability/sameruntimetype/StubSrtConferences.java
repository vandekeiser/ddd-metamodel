package fr.cla.ddd.metamodel.exampleapp.infra.equatability.sameruntimetype;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConferences;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtTalk;
import fr.cla.ddd.metamodel.exampleapp.infra.StubRepository;
import org.springframework.context.annotation.Profile;


@DDD.RepositoryImpl
@Profile("STUBBED_REPOS") @org.springframework.stereotype.Service
public class StubSrtConferences
extends StubRepository<SrtConference, ConferenceId>
implements SrtConferences {

    public StubSrtConferences() {
        super.add(new SrtConference(
            new ConferenceId("3a370dbe-13d3-4a85-b60e-632a2f4c44b6"),
            new MonetaryAmount(1000),
            new SrtTalk(new MonetaryAmount(100))
        ));
    }

    @Override
    public void add(SrtConference conf) {
        throw new UnsupportedOperationException();
    }

}

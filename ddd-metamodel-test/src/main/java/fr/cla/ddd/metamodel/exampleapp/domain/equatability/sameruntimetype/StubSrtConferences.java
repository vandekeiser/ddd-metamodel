package fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.StubRepository;
import org.springframework.context.annotation.Profile;


@DDD.RepositoryImpl
@Profile("STUBBED_REPOS") @org.springframework.stereotype.Service
public class StubSrtConferences
extends StubRepository<SrtConference, ConferenceId>
implements SrtConferences {

    public StubSrtConferences() {
        super.add(new SrtConference(
            new ConferenceId("33"),
            new MonetaryAmount(1000),
            new SrtTalk(new MonetaryAmount(100))
        ));
    }

    @Override
    public void add(SrtConference conf) {
        throw new UnsupportedOperationException();
    }

}

package fr.cla.ddd.metamodel.infra;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.domain.Conference;
import fr.cla.ddd.metamodel.domain.ConferenceId;
import fr.cla.ddd.metamodel.domain.Conferences;

import java.util.Optional;

@DDD.RepositoryImpl
public class SdjConferences implements Conferences {

    @Override
    public Optional<Conference> get(ConferenceId id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(Conference conf) {
        throw new UnsupportedOperationException();
    }

}

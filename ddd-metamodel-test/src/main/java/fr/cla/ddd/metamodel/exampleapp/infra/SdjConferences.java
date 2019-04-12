package fr.cla.ddd.metamodel.exampleapp.infra;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.Conference;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.Conferences;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

//@formatter:off
@DDD.RepositoryImpl
@org.springframework.stereotype.Repository
public class SdjConferences implements Conferences {

    private final ConferencesSdj sdj;

    public SdjConferences(ConferencesSdj sdj) {
        this.sdj = requireNonNull(sdj);
    }

    @Override
    public Optional<Conference> get(ConferenceId id) {
        return sdj.findById(id);
    }

    @Override
    public void add(Conference conf) {
        sdj.save(conf);
    }

}
//@formatter:on
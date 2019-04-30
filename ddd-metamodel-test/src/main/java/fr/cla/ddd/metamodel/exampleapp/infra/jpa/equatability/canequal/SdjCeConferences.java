package fr.cla.ddd.metamodel.exampleapp.infra.jpa.equatability.canequal;

import fr.cla.ddd.metamodel.domain.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal.CeConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal.CeConferences;
import org.springframework.context.annotation.Primary;

import java.util.Optional;

import static java.util.Objects.requireNonNull;


@DDD.RepositoryImpl
@Primary @org.springframework.stereotype.Repository
public class SdjCeConferences implements CeConferences {

    private final CeConferencesSdj sdj;

    public SdjCeConferences(CeConferencesSdj sdj) {
        this.sdj = requireNonNull(sdj);
    }

    @Override
    public Optional<CeConference> get(ConferenceId id) {
        return sdj.findById(id);
    }

    @Override
    public void add(CeConference conf) {
        sdj.save(conf);
    }

}

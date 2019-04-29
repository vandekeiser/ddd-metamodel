package fr.cla.ddd.metamodel.exampleapp.infra.equatability.sameruntimetype;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConferences;
import org.springframework.context.annotation.Primary;

import java.util.Optional;

import static java.util.Objects.requireNonNull;


@DDD.RepositoryImpl
@Primary @org.springframework.stereotype.Repository
public class SdjSrtConferences implements SrtConferences {

    private final SrtConferencesSdj sdj;

    public SdjSrtConferences(SrtConferencesSdj sdj) {
        this.sdj = requireNonNull(sdj);
    }

    @Override
    public Optional<SrtConference> get(ConferenceId id) {
        return sdj.findById(id);
    }

    @Override
    public void add(SrtConference conf) {
        sdj.save(conf);
    }

}

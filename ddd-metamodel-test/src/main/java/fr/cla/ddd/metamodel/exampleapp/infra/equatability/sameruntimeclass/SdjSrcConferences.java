package fr.cla.ddd.metamodel.exampleapp.infra.equatability.sameruntimeclass;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcConferences;
import org.springframework.context.annotation.Primary;

import java.util.Optional;

import static java.util.Objects.requireNonNull;


@DDD.RepositoryImpl
@Primary @org.springframework.stereotype.Repository
public class SdjSrcConferences implements SrcConferences {

    private final SrcConferencesSdj sdj;

    public SdjSrcConferences(SrcConferencesSdj sdj) {
        this.sdj = requireNonNull(sdj);
    }

    @Override
    public Optional<SrcConference> get(ConferenceId id) {
        return sdj.findById(id);
    }

    @Override
    public void add(SrcConference conf) {
        sdj.save(conf);
    }

}

package fr.cla.ddd.metamodel.exampleapp.infra.equatability.isinstance;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance.IiConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance.IiConferences;
import org.springframework.context.annotation.Primary;

import java.util.Optional;

import static java.util.Objects.requireNonNull;


@DDD.RepositoryImpl
@Primary @org.springframework.stereotype.Repository
public class SdjIiConferences implements IiConferences {

    private final IiConferencesSdj sdj;

    public SdjIiConferences(IiConferencesSdj sdj) {
        this.sdj = requireNonNull(sdj);
    }

    @Override
    public Optional<IiConference> get(ConferenceId id) {
        return sdj.findById(id);
    }

    @Override
    public void add(IiConference conf) {
        sdj.save(conf);
    }

}

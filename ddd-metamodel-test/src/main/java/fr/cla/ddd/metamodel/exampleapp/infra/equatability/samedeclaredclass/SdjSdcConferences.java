package fr.cla.ddd.metamodel.exampleapp.infra.equatability.samedeclaredclass;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredclass.SdcConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredclass.SdcConferences;
import org.springframework.context.annotation.Primary;

import java.util.Optional;

import static java.util.Objects.requireNonNull;


@DDD.RepositoryImpl
@Primary @org.springframework.stereotype.Repository
public class SdjSdcConferences implements SdcConferences {

    private final SdcConferencesSdj sdj;

    public SdjSdcConferences(SdcConferencesSdj sdj) {
        this.sdj = requireNonNull(sdj);
    }

    @Override
    public Optional<SdcConference> get(ConferenceId id) {
        return sdj.findById(id);
    }

    @Override
    public void add(SdcConference conf) {
        sdj.save(conf);
    }

}

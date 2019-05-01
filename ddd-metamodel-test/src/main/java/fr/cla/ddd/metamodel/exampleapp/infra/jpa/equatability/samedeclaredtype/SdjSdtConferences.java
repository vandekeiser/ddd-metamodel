package fr.cla.ddd.metamodel.exampleapp.infra.jpa.equatability.samedeclaredtype;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredtype.SdtConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredtype.SdtConferences;
import org.springframework.context.annotation.Primary;

import java.util.Optional;

import static java.util.Objects.requireNonNull;


@DDD.RepositoryImpl
@Primary @org.springframework.stereotype.Repository
public class SdjSdtConferences implements SdtConferences {

    private final SdtConferencesSdj sdj;

    public SdjSdtConferences(SdtConferencesSdj sdj) {
        this.sdj = requireNonNull(sdj);
    }

    @Override
    public Optional<SdtConference> get(ConferenceId id) {
        return sdj.findById(id);
    }

    @Override
    public void add(SdtConference conf) {
        sdj.save(conf);
    }

}

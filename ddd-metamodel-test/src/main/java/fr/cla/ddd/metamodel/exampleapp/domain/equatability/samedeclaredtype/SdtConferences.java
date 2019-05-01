package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredtype;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;

import java.util.Optional;


@DDD.Repository
public interface SdtConferences {

    Optional<SdtConference> get(ConferenceId id);

    void add(SdtConference conf);
    
}

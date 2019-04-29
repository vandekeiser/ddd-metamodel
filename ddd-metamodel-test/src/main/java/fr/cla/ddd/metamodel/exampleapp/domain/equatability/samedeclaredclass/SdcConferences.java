package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredclass;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;

import java.util.Optional;


@DDD.Repository
public interface SdcConferences {

    Optional<SdcConference> get(ConferenceId id);

    void add(SdcConference conf);
    
}

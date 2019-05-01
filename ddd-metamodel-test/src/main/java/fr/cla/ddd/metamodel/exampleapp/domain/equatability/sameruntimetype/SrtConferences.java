package fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;

import java.util.Optional;


@DDD.Repository
public interface SrtConferences {

    Optional<SrtConference> get(ConferenceId id);

    void add(SrtConference conf);
    
}

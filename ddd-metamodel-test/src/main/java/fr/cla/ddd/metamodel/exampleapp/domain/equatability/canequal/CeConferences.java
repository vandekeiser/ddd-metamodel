package fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;

import java.util.Optional;

//@formatter:off
@DDD.Repository
public interface CeConferences {

    Optional<CeConference> get(ConferenceId id);

    void add(CeConference conf);
    
}
//@formatter:on
package fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance;

import fr.cla.ddd.metamodel.domain.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;

import java.util.Optional;


@DDD.Repository
public interface IiConferences {

    Optional<IiConference> get(ConferenceId id);

    void add(IiConference conf);
    
}

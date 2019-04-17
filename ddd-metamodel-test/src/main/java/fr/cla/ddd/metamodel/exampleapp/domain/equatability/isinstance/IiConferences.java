package fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;

import java.util.Optional;

//@formatter:off
@DDD.Repository
public interface IiConferences {

    Optional<IiConference> get(ConferenceId id);

    void add(IiConference conf);
    
}
//@formatter:on
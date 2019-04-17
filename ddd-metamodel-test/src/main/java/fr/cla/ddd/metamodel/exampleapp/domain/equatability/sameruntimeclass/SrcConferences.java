package fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;

import java.util.Optional;

//@formatter:off
@DDD.Repository
public interface SrcConferences {

    Optional<SrcConference> get(ConferenceId id);

    void add(SrcConference conf);
    
}
//@formatter:on
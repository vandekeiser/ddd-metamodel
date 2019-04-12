package fr.cla.ddd.metamodel.domain;

import fr.cla.ddd.metamodel.DDD;

import java.util.Optional;

//@formatter:off
@DDD.Repository
public interface Conferences {

    Optional<Conference> get(ConferenceId id);

    void add(Conference conf);
}
//@formatter:on
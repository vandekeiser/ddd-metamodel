package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.DDD;

//@formatter:off
@DDD.RepositoryImpl
@org.springframework.stereotype.Service
public class InMemoryConferences
extends InMemoryRepository<Conference, ConferenceId>
implements Conferences {


}
//@formatter:on
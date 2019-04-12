package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.DDD;

@DDD.RepositoryImpl
public class InMemoryConferences
extends InMemoryRepository<Conference, ConferenceId>
implements Conferences {


}

package fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.InMemoryRepository;

//@formatter:off
@DDD.RepositoryImpl
@org.springframework.stereotype.Service
public class InMemoryCeConferences
extends InMemoryRepository<CeConference, ConferenceId>
implements CeConferences {


}
//@formatter:on
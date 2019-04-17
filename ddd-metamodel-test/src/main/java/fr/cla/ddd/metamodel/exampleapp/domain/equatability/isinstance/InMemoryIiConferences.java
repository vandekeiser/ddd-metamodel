package fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.InMemoryRepository;

//@formatter:off
@DDD.RepositoryImpl
@org.springframework.stereotype.Service
public class InMemoryIiConferences
extends InMemoryRepository<IiConference, ConferenceId>
implements IiConferences {


}
//@formatter:on
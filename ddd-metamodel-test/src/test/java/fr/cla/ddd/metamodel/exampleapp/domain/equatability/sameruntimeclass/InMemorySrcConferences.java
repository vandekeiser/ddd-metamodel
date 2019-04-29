package fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.InMemoryRepository;


@DDD.RepositoryImpl
@org.springframework.stereotype.Service
public class InMemorySrcConferences
extends InMemoryRepository<SrcConference, ConferenceId>
implements SrcConferences {


}

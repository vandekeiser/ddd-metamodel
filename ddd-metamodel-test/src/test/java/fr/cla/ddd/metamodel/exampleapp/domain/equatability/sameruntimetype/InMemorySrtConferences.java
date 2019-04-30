package fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype;

import fr.cla.ddd.metamodel.domain.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.InMemoryRepository;


@DDD.RepositoryImpl
@org.springframework.stereotype.Service
public class InMemorySrtConferences
extends InMemoryRepository<SrtConference, ConferenceId>
implements SrtConferences {


}

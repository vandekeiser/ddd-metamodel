package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredtype;

import fr.cla.ddd.metamodel.domain.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.InMemoryRepository;


@DDD.RepositoryImpl
@org.springframework.stereotype.Service
public class InMemorySdtConferences
extends InMemoryRepository<SdtConference, ConferenceId>
implements SdtConferences {


}

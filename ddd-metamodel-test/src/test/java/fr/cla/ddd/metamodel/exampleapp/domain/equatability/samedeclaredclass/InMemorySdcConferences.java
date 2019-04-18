package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredclass;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.InMemoryRepository;

//@formatter:off
@DDD.RepositoryImpl
@org.springframework.stereotype.Service
public class InMemorySdcConferences
extends InMemoryRepository<SdcConference, ConferenceId>
implements SdcConferences {


}
//@formatter:on
package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredtype;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.FakeRepository;


@DDD.RepositoryImpl
@org.springframework.stereotype.Service
public class FakeSdtConferences
extends FakeRepository<SdtConference, ConferenceId>
implements SdtConferences {


}

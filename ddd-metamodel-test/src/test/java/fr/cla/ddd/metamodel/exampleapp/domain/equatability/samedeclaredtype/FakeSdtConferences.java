package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredtype;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.domain.FakeRepository;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;


@DDD.RepositoryImpl
@org.springframework.stereotype.Service
public class FakeSdtConferences
extends FakeRepository<SdtConference, ConferenceId>
implements SdtConferences {


}

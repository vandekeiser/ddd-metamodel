package fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.FakeRepository;


@DDD.RepositoryImpl
@org.springframework.stereotype.Service
public class FakeIiConferences
extends FakeRepository<IiConference, ConferenceId>
implements IiConferences {


}

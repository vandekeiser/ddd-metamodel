package fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.domain.FakeRepository;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;


@DDD.RepositoryImpl
@org.springframework.stereotype.Service
public class FakeIiConferences
extends FakeRepository<IiConference, ConferenceId>
implements IiConferences {


}

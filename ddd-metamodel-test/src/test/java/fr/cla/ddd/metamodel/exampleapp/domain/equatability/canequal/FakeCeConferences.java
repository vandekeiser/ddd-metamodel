package fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.FakeRepository;


@DDD.RepositoryImpl
@org.springframework.stereotype.Service
public class FakeCeConferences
extends FakeRepository<CeConference, ConferenceId>
implements CeConferences {


}

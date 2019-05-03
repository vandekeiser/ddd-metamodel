package fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.FakeRepository;


@DDD.RepositoryImpl
@org.springframework.stereotype.Service
public class FakeSrtConferences
extends FakeRepository<SrtConference, ConferenceId>
implements SrtConferences {


}

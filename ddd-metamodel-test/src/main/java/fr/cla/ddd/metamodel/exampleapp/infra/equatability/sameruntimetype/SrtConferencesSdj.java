package fr.cla.ddd.metamodel.exampleapp.infra.equatability.sameruntimetype;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SrtConferencesSdj extends JpaRepository<SrtConference, ConferenceId> {
}

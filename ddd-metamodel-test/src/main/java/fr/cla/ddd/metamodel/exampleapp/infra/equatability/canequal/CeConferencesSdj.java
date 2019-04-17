package fr.cla.ddd.metamodel.exampleapp.infra.equatability.canequal;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal.CeConference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeConferencesSdj extends JpaRepository<CeConference, ConferenceId> {
}

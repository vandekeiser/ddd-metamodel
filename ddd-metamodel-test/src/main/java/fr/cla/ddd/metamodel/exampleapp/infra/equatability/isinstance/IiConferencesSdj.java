package fr.cla.ddd.metamodel.exampleapp.infra.equatability.isinstance;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance.IiConference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IiConferencesSdj extends JpaRepository<IiConference, ConferenceId> {
}

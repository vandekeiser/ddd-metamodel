package fr.cla.ddd.metamodel.exampleapp.infra.equatability.samedeclaredtype;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredtype.SdtConference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SdtConferencesSdj extends JpaRepository<SdtConference, ConferenceId> {
}

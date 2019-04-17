package fr.cla.ddd.metamodel.exampleapp.infra.equatability.samedeclaredclass;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredclass.SdcConference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SdcConferencesSdj extends JpaRepository<SdcConference, ConferenceId> {
}

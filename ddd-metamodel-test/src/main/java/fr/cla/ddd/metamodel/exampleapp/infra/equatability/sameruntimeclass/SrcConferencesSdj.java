package fr.cla.ddd.metamodel.exampleapp.infra.equatability.sameruntimeclass;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcConference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SrcConferencesSdj extends JpaRepository<SrcConference, ConferenceId> {
}

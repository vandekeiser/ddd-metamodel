package fr.cla.ddd.metamodel.exampleapp.infra;

import fr.cla.ddd.metamodel.exampleapp.domain.Conference;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferencesSdj extends JpaRepository<Conference, ConferenceId> {
}

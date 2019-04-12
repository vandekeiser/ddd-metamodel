package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.Conference;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.Conferences;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

//@formatter:off
@DDD.ApplicationService
@Transactional @org.springframework.stereotype.Service
public class ViewConferenceDetails {

    private final Conferences conferences;

    public ViewConferenceDetails(Conferences conferences) {
        this.conferences = requireNonNull(conferences);
    }

    public Optional<Conference> viewConferenceDetails(ConferenceId id) {
        return conferences.get(id);
    }


}
//@formatter:on
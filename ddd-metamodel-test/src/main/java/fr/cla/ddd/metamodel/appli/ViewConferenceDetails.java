package fr.cla.ddd.metamodel.appli;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.domain.Conference;
import fr.cla.ddd.metamodel.domain.ConferenceId;
import fr.cla.ddd.metamodel.domain.Conferences;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

//@formatter:off
@DDD.ApplicationService
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
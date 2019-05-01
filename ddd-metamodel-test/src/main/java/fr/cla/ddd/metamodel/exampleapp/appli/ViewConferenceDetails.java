package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConferences;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Objects.requireNonNull;


@DDD.ApplicationService
@Transactional @org.springframework.stereotype.Service
public class ViewConferenceDetails {

    private final SrtConferences conferences;

    public ViewConferenceDetails(SrtConferences conferences) {
        this.conferences = requireNonNull(conferences);
    }

    public Optional<SrtConferenceDetails> viewConferenceDetails(ConferenceId id) {
        return conferences.get(id).map(SrtConferenceDetails::new);
    }

}

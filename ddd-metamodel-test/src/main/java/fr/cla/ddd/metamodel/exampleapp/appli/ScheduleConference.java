package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.appli.ApplicativeValidations;
import fr.cla.ddd.metamodel.appli.InvalidCommandOrQueryException;
import fr.cla.ddd.metamodel.domain.DDD;
import fr.cla.ddd.metamodel.domain.validation.InvalidObjectException;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.requireNonNull;


@DDD.ApplicationService
@Transactional @org.springframework.stereotype.Service
public class ScheduleConference {

    private static final Logger log = LoggerFactory.getLogger(ScheduleConference.class);

    private final SrtConferences conferences;

    public ScheduleConference(SrtConferences conferences) {
        this.conferences = requireNonNull(conferences);
    }

    public void scheduleConference(ScheduleConferenceCommand cmd) {
        log.info("Received command {}", cmd);
        //The rest api might have validated the schema,
        // but we also must take into account validations that can only be done in the backend
        //(eg. translate them to 400).
        //This is just an example, but this validation could use eg. a database unicity check or a rest-client check of existence in another bounded context.
        SrtConference conf = ApplicativeValidations.validateApplicatively(cmd, ScheduleConferenceCommand::createConference);
        log.info("Created {} to add it", conf);
        conferences.add(conf);
        log.info("Added {}", conf);
    }

}

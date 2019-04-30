package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Objects.requireNonNull;


@DDD.ApplicationService
@Transactional @org.springframework.stereotype.Service
public class ScheduleConference {

    private static final Logger log = LoggerFactory.getLogger(SrtConference.class);

    private final SrtConferences conferences;

    public ScheduleConference(SrtConferences conferences) {
        this.conferences = requireNonNull(conferences);
    }

    //choose later
    //public SrtConference scheduleConference(ScheduleConferenceCommand cmd) throws Illegal {
    //public SrtConferenceId scheduleConference(ScheduleConferenceCommand cmd) throws Illegal {
    //public Optional<SrtConference> scheduleConference(ScheduleConferenceCommand cmd) {
    //public Optional<Id> scheduleConference(ScheduleConferenceCommand cmd) {
    //public Outcome scheduleConference(ScheduleConferenceCommand cmd) {

    /**
     * The rest api might have validated the schema, but it also must take into account
     * (eg. translate them to 400)
     */
    public /*TODO Optional<ConferenceId>*/void scheduleConference(ScheduleConferenceCommand cmd) {
        log.info("Received {}", cmd);
        SrtConference conf = cmd.createConference();
        log.info("Created {} to add it", conf);
        conferences.add(conf);
        log.info("Added {}", conf);
    }

}

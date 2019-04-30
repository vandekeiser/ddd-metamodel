package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConferences;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.requireNonNull;


@DDD.ApplicationService
@Transactional @org.springframework.stereotype.Service
public class ScheduleConference {

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
    public void scheduleConference(ScheduleConferenceCommand cmd) {
        SrtConference conf = cmd.createConference();
        conferences.add(conf);
    }


}

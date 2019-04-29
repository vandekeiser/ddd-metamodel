package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcConferences;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.requireNonNull;


@DDD.ApplicationService
@Transactional @org.springframework.stereotype.Service
public class ScheduleConference {

    private final SrcConferences conferences;

    public ScheduleConference(SrcConferences conferences) {
        this.conferences = requireNonNull(conferences);
    }

    //choose later
    //public SrcConference scheduleConference(ScheduleConferenceCommand cmd) throws Illegal {
    //public SrcConferenceId scheduleConference(ScheduleConferenceCommand cmd) throws Illegal {
    //public Optional<SrcConference> scheduleConference(ScheduleConferenceCommand cmd) {
    //public Optional<Id> scheduleConference(ScheduleConferenceCommand cmd) {
    //public Outcome scheduleConference(ScheduleConferenceCommand cmd) {
    public void scheduleConference(ScheduleConferenceCommand cmd) {
        SrcConference conf = cmd.toConference();
        conferences.add(conf);
    }


}

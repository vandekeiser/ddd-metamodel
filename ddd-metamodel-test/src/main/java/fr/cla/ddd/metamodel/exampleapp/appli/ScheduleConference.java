package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.Conference;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.Conferences;
import fr.cla.ddd.metamodel.exampleapp.domain.Talk;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.requireNonNull;

//@formatter:off
@DDD.ApplicationService
@Transactional @org.springframework.stereotype.Service
public class ScheduleConference {

    private final Conferences conferences;

    public ScheduleConference(Conferences conferences) {
        this.conferences = requireNonNull(conferences);
    }

    public void scheduleConference(ScheduleConferenceCommand cmd) {
        Conference conf = cmd.toConference();
        conferences.add(conf);
    }


}
//@formatter:on
package fr.cla.ddd.metamodel.appli;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.domain.Conference;
import fr.cla.ddd.metamodel.domain.ConferenceId;
import fr.cla.ddd.metamodel.domain.Conferences;
import fr.cla.ddd.metamodel.domain.Talk;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

//@formatter:off
@DDD.ApplicationService
public class ScheduleConference {

    private final Conferences conferences;

    public ScheduleConference(Conferences conferences) {
        this.conferences = requireNonNull(conferences);
    }

    public ConferenceId scheduleConference(ScheduleConferenceCommand cmd) {
        Conference conf = new Conference(
            new ConferenceId(),
            cmd.getBudget(),
            cmd.mapCosts(Talk::new)
        );
        conferences.add(conf);
        return conf.getId();
    }


}
//@formatter:on
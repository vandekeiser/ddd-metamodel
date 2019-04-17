package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcConferences;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.requireNonNull;

//@formatter:off
@DDD.ApplicationService
@Transactional @org.springframework.stereotype.Service
public class ScheduleConference {

    private final SrcConferences conferences;

    public ScheduleConference(SrcConferences conferences) {
        this.conferences = requireNonNull(conferences);
    }

    public void scheduleConference(ScheduleConferenceCommand cmd) {
        SrcConference conf = cmd.toConference();
        conferences.add(conf);
    }


}
//@formatter:on
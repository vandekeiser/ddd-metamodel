package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.exampleapp.domain.*;
import org.junit.Test;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
public class ScheduleConferenceTest {

    private final Conferences conferences = new InMemoryConferences();
    private final ScheduleConference scheduleConference = new ScheduleConference(conferences);

    @Test
    public void when_the_conference_is_scheduled_it_should_be_added() {
        ScheduleConferenceCommand cmd;
        Conference scheduledConference;

        given: {
            cmd = scheduleConferenceCommand();
            scheduledConference = cmd.toConference();
            assertThat(
                conferences.get(scheduledConference.getId())
            ).isEmpty();
        }

        when: {
            scheduleConference.scheduleConference(cmd);
        }

        then: {
            assertThat(
                conferences.get(scheduledConference.getId())
            ).isEqualTo(
                Optional.of(scheduledConference)
            );
        }
    }

    private ScheduleConferenceCommand scheduleConferenceCommand() {
        return new ScheduleConferenceCommand(
            new MonetaryAmount(1000),
            Set.of(new MonetaryAmount(200), new MonetaryAmount(300), new MonetaryAmount(500))
        );
    }

}
//@formatter:on
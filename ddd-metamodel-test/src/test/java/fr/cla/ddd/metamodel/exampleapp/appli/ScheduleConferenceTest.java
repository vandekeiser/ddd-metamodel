package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.FakeSrtConferences;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConferences;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class ScheduleConferenceTest {

    private final SrtConferences conferences = new FakeSrtConferences();
    private final ScheduleConference scheduleConference = new ScheduleConference(conferences);

    @Test
    public void when_the_conference_is_scheduled_it_should_be_added() {
        ScheduleConferenceCommand cmd;
        SrtConference scheduledConference;

        given: {
            cmd = scheduleConferenceCommand();
            scheduledConference = cmd.createConference();
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
            List.of(new MonetaryAmount(200), new MonetaryAmount(300), new MonetaryAmount(500))
        );
    }

}

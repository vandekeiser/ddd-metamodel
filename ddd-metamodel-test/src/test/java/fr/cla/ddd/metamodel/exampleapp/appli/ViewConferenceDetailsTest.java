package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.exampleapp.domain.Conference;
import fr.cla.ddd.metamodel.exampleapp.domain.Conferences;
import fr.cla.ddd.metamodel.exampleapp.domain.InMemoryConferences;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import org.junit.Test;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
public class ViewConferenceDetailsTest {

    private final Conferences conferences = new InMemoryConferences();
    private final ViewConferenceDetails viewConferenceDetails = new ViewConferenceDetails(conferences);

    @Test
    public void when_there_is_a_conference_we_should_be_able_to_view_its_details() {
        Conference addedConference;
        Optional<Conference> conferenceDetails;

        given: {
            addedConference = createConference();
            conferences.add(addedConference);
        }

        when: {
            conferenceDetails = viewConferenceDetails.viewConferenceDetails(
                addedConference.getId()
            );
        }

        then: {
            assertThat(
                conferenceDetails
            ).isEqualTo(
                Optional.of(addedConference)
            );
        }
    }

    private Conference createConference() {
        return new ScheduleConferenceCommand(
            new MonetaryAmount(1000),
            Set.of(new MonetaryAmount(200), new MonetaryAmount(300), new MonetaryAmount(500))
        ).toConference();
    }

}
//@formatter:on
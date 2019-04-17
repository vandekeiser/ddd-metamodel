package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.InMemorySrcConferences;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcConferences;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
public class ViewConferenceDetailsTest {

    private final SrcConferences conferences = new InMemorySrcConferences();
    private final ViewConferenceDetails viewConferenceDetails = new ViewConferenceDetails(conferences);

    @Test
    public void when_there_is_a_conference_we_should_be_able_to_view_its_details() {
        SrcConference addedConference;
        Optional<SrcConference> conferenceDetails;

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

    private SrcConference createConference() {
        return new ScheduleConferenceCommand(
            new MonetaryAmount(1000),
            Set.of(new MonetaryAmount(200), new MonetaryAmount(300), new MonetaryAmount(500))
        ).toConference();
    }

}
//@formatter:on
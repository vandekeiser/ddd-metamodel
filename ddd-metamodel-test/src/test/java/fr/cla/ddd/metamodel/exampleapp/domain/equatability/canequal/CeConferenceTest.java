package fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CeConferenceTest {

    @Test
    public void should_not_instantiate_invalid() {
        assertThrows(IllegalArgumentException.class, () ->
            new CeConference(
                new ConferenceId(),
                new MonetaryAmount(1000),
                new CeTalk(new MonetaryAmount(500)),
                new CeTalk(new MonetaryAmount(500)),
                new CeTalk(new MonetaryAmount(1))
            )
        );
    }

    @Test
    public void should_not_rollover_silently() {
        try {
            //When
            CeConference invalid = new CeConference(
                new ConferenceId(),
                new MonetaryAmount(Integer.MAX_VALUE),
                //sum is 1, which is > 0 and <budget, but rolls over
                new CeTalk(new MonetaryAmount(Integer.MAX_VALUE)),
                new CeTalk(new MonetaryAmount(Integer.MAX_VALUE)),
                new CeTalk(new MonetaryAmount(3))
            );

            fail("Should have failed invalid CeConference" + invalid);
        } catch (IllegalArgumentException expected) {
            //Then
            expected.printStackTrace();

            //And
            Throwable[] validationErrors = expected.getSuppressed();
            assertThat(validationErrors.length).isEqualTo(1);

            //And
            Throwable overflow = validationErrors[0];
            assertThat(overflow).isInstanceOf(ArithmeticException.class);
            assertThat(overflow.getMessage()).isEqualTo("integer overflow");
        }
    }

    @Test
    public void should_instantiate_valid_CeConference() {
        assertDoesNotThrow(() ->
            new CeConference(
                new ConferenceId(),
                new MonetaryAmount(1000),
                new CeTalk(new MonetaryAmount(500)),
                new CeTalk(new MonetaryAmount(500))
            )
        );
    }

}

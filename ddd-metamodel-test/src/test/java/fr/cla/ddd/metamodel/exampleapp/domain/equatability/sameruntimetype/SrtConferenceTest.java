package fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype;

import fr.cla.ddd.metamodel.domain.validation.ValidationException;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SrtConferenceTest {

    @Test
    public void should_not_instantiate_invalid() {
        assertThrows(ValidationException.class, () ->
            new SrtConference(
                new ConferenceId(),
                new MonetaryAmount(1000),
                new SrtTalk(new MonetaryAmount(500)),
                new SrtTalk(new MonetaryAmount(500)),
                new SrtTalk(new MonetaryAmount(1))
            )
        );
    }

    @Test
    public void should_not_rollover_silently() {
        try {
            //When
            SrtConference invalid = new SrtConference(
                new ConferenceId(),
                new MonetaryAmount(Integer.MAX_VALUE),
                //sum is 1, which is > 0 and <budget, but rolls over
                new SrtTalk(new MonetaryAmount(Integer.MAX_VALUE)),
                new SrtTalk(new MonetaryAmount(Integer.MAX_VALUE)),
                new SrtTalk(new MonetaryAmount(3))
            );

            fail("Should have failed invalid CeConference" + invalid);
        } catch (ValidationException expected) {
            //Then
            expected.printStackTrace();

            //And
            ValidationException[] validationErrors = expected.getSuppressedValidationException();
            assertThat(validationErrors.length).isEqualTo(1);

            //And
            ValidationException overflow = validationErrors[0];
            assertThat(overflow.getMessage()).isEqualTo("integer overflow");
            assertThat(overflow.getCause()).isInstanceOf(ArithmeticException.class);
        }
    }

    @Test
    public void should_instantiate_valid_CeConference() {
        assertDoesNotThrow(() ->
            new SrtConference(
                new ConferenceId(),
                new MonetaryAmount(1000),
                new SrtTalk(new MonetaryAmount(500)),
                new SrtTalk(new MonetaryAmount(500))
            )
        );
    }

}

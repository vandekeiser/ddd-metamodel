package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredtype;

import fr.cla.ddd.metamodel.domain.validation.AbstractValidationException;
import fr.cla.ddd.metamodel.domain.validation.InvalidObjectException;
import fr.cla.ddd.metamodel.domain.validation.UnexpectedExceptionDuringValidationException;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SdtConferenceTest {

    @Test
    public void should_not_instantiate_invalid() {
        assertThrows(InvalidObjectException.class, () ->
            new SdtConference(
                new ConferenceId(),
                new MonetaryAmount(1000),
                new SdtTalk(new MonetaryAmount(500)),
                new SdtTalk(new MonetaryAmount(500)),
                new SdtTalk(new MonetaryAmount(1))
            )
        );
    }

    @Test
    public void should_not_rollover_silently() {
        try {
            //When
            SdtConference invalid = new SdtConference(
                new ConferenceId(),
                new MonetaryAmount(Integer.MAX_VALUE),
                //sum is 1, which is > 0 and <budget, but rolls over
                new SdtTalk(new MonetaryAmount(Integer.MAX_VALUE)),
                new SdtTalk(new MonetaryAmount(Integer.MAX_VALUE)),
                new SdtTalk(new MonetaryAmount(3))
            );

            fail("Should have failed invalid CeConference" + invalid);
        } catch (InvalidObjectException expected) {
            //Then
            expected.printStackTrace();

            //And
            AbstractValidationException[] validationErrors = expected.getSuppressedValidationException();
            assertThat(validationErrors.length).isEqualTo(1);

            //And
            AbstractValidationException overflow = validationErrors[0];
            assertThat(overflow).isInstanceOf(UnexpectedExceptionDuringValidationException.class);
            assertThat(overflow.getMessage()).isEqualTo("java.lang.ArithmeticException: integer overflow");
            assertThat(overflow.getCause()).isInstanceOf(ArithmeticException.class);
        }
    }

    @Test
    public void should_instantiate_valid_CeConference() {
        assertDoesNotThrow(() ->
            new SdtConference(
                new ConferenceId(),
                new MonetaryAmount(1000),
                new SdtTalk(new MonetaryAmount(500)),
                new SdtTalk(new MonetaryAmount(500))
            )
        );
    }

}

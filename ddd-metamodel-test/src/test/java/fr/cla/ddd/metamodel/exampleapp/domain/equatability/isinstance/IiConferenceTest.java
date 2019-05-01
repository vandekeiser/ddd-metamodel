package fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance;

import fr.cla.ddd.metamodel.domain.validation.AbstractValidationException;
import fr.cla.ddd.metamodel.domain.validation.InvalidObjectException;
import fr.cla.ddd.metamodel.domain.validation.UnexpectedExceptionDuringValidationException;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class IiConferenceTest {

    @Test
    public void should_not_instantiate_invalid() {
        assertThrows(InvalidObjectException.class, () ->
            new IiConference(
                new ConferenceId(),
                new MonetaryAmount(1000),
                new IiTalk(new MonetaryAmount(500)),
                new IiTalk(new MonetaryAmount(500)),
                new IiTalk(new MonetaryAmount(1))
            )
        );
    }

    @Test
    public void should_not_rollover_silently() {
        try {
            //When
            IiConference invalid = new IiConference(
                new ConferenceId(),
                new MonetaryAmount(Integer.MAX_VALUE),
                //sum is 1, which is > 0 and <budget, but rolls over
                new IiTalk(new MonetaryAmount(Integer.MAX_VALUE)),
                new IiTalk(new MonetaryAmount(Integer.MAX_VALUE)),
                new IiTalk(new MonetaryAmount(3))
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
            new IiConference(
                new ConferenceId(),
                new MonetaryAmount(1000),
                new IiTalk(new MonetaryAmount(500)),
                new IiTalk(new MonetaryAmount(500))
            )
        );
    }

}

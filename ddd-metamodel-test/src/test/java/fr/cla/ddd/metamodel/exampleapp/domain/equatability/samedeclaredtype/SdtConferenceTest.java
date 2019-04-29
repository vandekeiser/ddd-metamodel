package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredtype;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SdtConferenceTest {

    @Test
    public void should_not_instantiate_invalid_CeConference() {
        assertThrows(IllegalArgumentException.class, () ->
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

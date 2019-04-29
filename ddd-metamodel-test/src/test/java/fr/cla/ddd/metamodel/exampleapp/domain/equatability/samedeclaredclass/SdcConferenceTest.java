package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredclass;

import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SdcConferenceTest {

    @Test
    public void should_not_instantiate_invalid_CeConference() {
        assertThrows(IllegalArgumentException.class, () ->
            new SdcConference(
                new ConferenceId(),
                new MonetaryAmount(1000),
                new SdcTalk(new MonetaryAmount(500)),
                new SdcTalk(new MonetaryAmount(500)),
                new SdcTalk(new MonetaryAmount(1))
            )
        );
    }

    @Test
    public void should_instantiate_valid_CeConference() {
        assertDoesNotThrow(() ->
            new SdcConference(
                new ConferenceId(),
                new MonetaryAmount(1000),
                new SdcTalk(new MonetaryAmount(500)),
                new SdcTalk(new MonetaryAmount(500))
            )
        );
    }

}

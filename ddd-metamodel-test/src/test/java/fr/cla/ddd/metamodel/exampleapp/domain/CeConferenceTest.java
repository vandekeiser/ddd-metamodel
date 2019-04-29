package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal.CeConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal.CeTalk;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CeConferenceTest {

    @Test
    public void should_not_instantiate_invalid_CeConference() {
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

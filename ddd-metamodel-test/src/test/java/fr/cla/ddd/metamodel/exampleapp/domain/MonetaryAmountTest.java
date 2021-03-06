package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.domain.validation.InvalidObjectException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MonetaryAmountTest {

    @Test
    public void constructor_should_throw_when_invalid_parameters() {
        assertThrows(InvalidObjectException.class, () ->
            new MonetaryAmount(-1)
        );

    }

    @Test
    public void constructor_should_not_throw_when_valid_parameters() {
        assertDoesNotThrow(() ->
            new MonetaryAmount(0)
        );
    }

    @Test
    public void isSmallerThanOrEqualTo() {
        assertThat(
            new MonetaryAmount(2).isSmallerThanOrEqualTo(new MonetaryAmount(2))
        ).isTrue();

        assertThat(
            new MonetaryAmount(2).isSmallerThanOrEqualTo(new MonetaryAmount(3))
        ).isTrue();

        assertThat(
            new MonetaryAmount(2).isSmallerThanOrEqualTo(new MonetaryAmount(1))
        ).isFalse();
    }

}

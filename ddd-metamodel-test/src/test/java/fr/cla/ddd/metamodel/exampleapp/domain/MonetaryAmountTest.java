package fr.cla.ddd.metamodel.exampleapp.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MonetaryAmountTest {

    @Test
    public void should_not_instantiate_invalid_MonetaryAmount() {
        assertThrows(IllegalArgumentException.class, () ->
            new MonetaryAmount(-1)
        );

    }

    @Test
    public void should_instantiate_valid_MonetaryAmount() {
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

package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.AbstractValueObjectTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MonetaryAmountTest {

    @Test
    public void should_not_instantiate_invalid_MonetaryAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MonetaryAmount(-1);
        });

    }

    @Test
    public void should_instantiate_valid_MonetaryAmount() {
        assertDoesNotThrow(() -> {
            new MonetaryAmount(0);
        });
    }

}

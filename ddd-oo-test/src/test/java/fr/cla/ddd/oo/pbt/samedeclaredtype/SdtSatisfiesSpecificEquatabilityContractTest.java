package fr.cla.ddd.oo.pbt.samedeclaredtype;


import fr.cla.ddd.oo.pbt.EqualPair;
import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.PropertyCheck;
import fr.cla.ddd.oo.pbt.samedeclaredtype.generators.ArbitrarySdts;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;

import static org.assertj.core.api.Assertions.assertThat;


public class SdtSatisfiesSpecificEquatabilityContractTest
extends ArbitrarySdts {

    @PropertyCheck
    public void when_equals_is_true_then_declared_classes_should_be_equal(@ForAll("equalPairs") EqualPair p) {
        Assume.that(p.x.equals(p.y));

        assertThat(
            p.x.getDeclaredType().equals(p.y.getClass())
        )
        .as(
            "Expected equal SAME_DECLARED_TYPE Equatables to have equal declared classes. Actual: %n" +
                "    p.x: %s%n" +
                "    p.y: %s%n" +
                "    p.x.equals(p.y): %b%n" +
                "    p.x.getDeclaredType(): %s%n" +
                "    p.y.getDeclaredType(): %s%n" +
                "    p.x.getDeclaredType().equals(p.y.getDeclaredType(): %b",
            p.x, p.y, p.x.equals(p.y),
            p.x.getDeclaredType(),
            p.y.getDeclaredType(),
            p.x.getDeclaredType().equals(p.y.getDeclaredType())
        )
        .isTrue();
    }

    @PropertyCheck
    public void when_declared_classes_are_not_equal_then_equals_should_be_false(@ForAll("equatablePairs") EquatablePair p) {
        Assume.that(
            !p.x.getDeclaredType().equals(p.y.getDeclaredType())
        );

        assertThat(
            p.x.equals(p.y)
        )
        .as(
            "Expected SAME_DECLARED_TYPE Equatables with different declared classes to not be equal. Actual: %n" +
                "    p.x: %s%n" +
                "    p.y: %s%n" +
                "    p.x.equals(p.y): %b%n" +
                "    p.x.getDeclaredType(): %s%n" +
                "    p.y.getDeclaredType(): %s%n" +
                "    p.x.getDeclaredType().equals(p.y.getDeclaredType(): %b",
            p.x, p.y, p.x.equals(p.y),
            p.x.getDeclaredType(),
            p.y.getDeclaredType(),
            p.x.getDeclaredType().equals(p.y.getDeclaredType())
        )
        .isFalse();
    }

}


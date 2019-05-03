package fr.cla.ddd.oo.pbt.sameruntimetype;


import fr.cla.ddd.oo.pbt.EqualPair;
import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.PropertyCheck;
import fr.cla.ddd.oo.pbt.sameruntimetype.generators.ArbitrarySrts;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;

import static org.assertj.core.api.Assertions.assertThat;


public class SrtSatisfiesSpecificEquatabilityContractTest
extends ArbitrarySrts {

    @PropertyCheck
    public void when_equals_is_true_then_runtime_classes_should_be_equal(@ForAll("equalPairs") EqualPair p) {
        Assume.that(p.x.equals(p.y));

        assertThat(
            p.x.getClass().equals(p.y.getClass())
        )
        .as(
            "Expected equal SAME_RUNTIME_TYPE Equatables to have equal runtime classes. Actual: %n" +
            "    p.x: %s%n" +
            "    p.y: %s%n" +
            "    p.x.equals(p.y): %b%n" +
            "    p.x.getClass(): %s%n" +
            "    p.y.getClass(): %s%n" +
            "    p.x.getClass().equals(p.y.getClass(): %b",
            p.x, p.y, p.x.equals(p.y),
            p.x.getClass(),
            p.y.getClass(),
            p.x.getClass().equals(p.y.getClass())
        )
        .isTrue();
    }

    @PropertyCheck
    public void when_runtime_classes_are_not_equal_then_equals_should_be_false(@ForAll("equatablePairs") EquatablePair p) {
        Assume.that(
            !p.x.getClass().equals(p.y.getClass())
        );

        assertThat(
            p.x.equals(p.y)
        )
        .as(
            "Expected SAME_RUNTIME_TYPE Equatables with different runtime classes to not be equal. Actual: %n" +
                "    p.x: %s%n" +
                "    p.y: %s%n" +
                "    p.x.equals(p.y): %b%n" +
                "    p.x.getClass(): %s%n" +
                "    p.y.getClass(): %s%n" +
                "    p.x.getClass().equals(p.y.getClass(): %b",
            p.x, p.y, p.x.equals(p.y),
            p.x.getClass(), p.y.getClass(), p.x.getClass().equals(p.y.getClass())
        )
        .isFalse();
    }

}


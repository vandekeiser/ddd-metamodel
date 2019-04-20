package fr.cla.ddd.oo.pbt.isinstance;


import fr.cla.ddd.oo.pbt.EqualPair;
import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.PropertyCheck;
import fr.cla.ddd.oo.pbt.isinstance.generators.ArbitraryIis;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
public class IiSatisfiesSpecificEquatabilityContractTest
extends ArbitraryIis {

    @PropertyCheck
    public void when_equals_is_true_then_both_should_be_an_instance_of_the_others_declared_type(@ForAll("equalPairs") EqualPair p) {
        Assume.that(
            p.x.equals(p.y)
        );

        assertThat(
            p.x.getDeclaredType().isInstance(p.y)
                &&
            p.y.getDeclaredType().isInstance(p.x)
        )
        .as(
            "Expected IS_INSTANCE Equatables that are not instances of each other's declared type to not be equal. Actual: %n" +
                "    p.x: %s%n" +
                "    p.y: %s%n" +
                "    p.x.equals(p.y): %b%n" +
                "    p.x.getDeclaredType(): %s%n" +
                "    p.y.getDeclaredType(): %s%n" +
                "    p.x.getDeclaredType().isInstance(p.y): %b" +
                "    p.y.getDeclaredType().isInstance(p.x): %b" +
                "    p.x.getDeclaredType().isInstance(p.y) && p.y.getDeclaredType().isInstance(p.x)",
            p.x, p.y, p.x.equals(p.y),
            p.x.getDeclaredType(),
            p.y.getDeclaredType(),
            p.x.getDeclaredType().isInstance(p.y),
            p.y.getDeclaredType().isInstance(p.x),
            p.x.getDeclaredType().isInstance(p.y) && p.y.getDeclaredType().isInstance(p.x)
        )
        .isTrue();
    }

    @PropertyCheck
    public void when_both_are_not_instances_of_each_others_declared_type_then_equals_should_be_false(@ForAll("equatablePairs") EquatablePair p) {
        Assume.that(!(
            p.x.getDeclaredType().isInstance(p.y)
                &&
                p.y.getDeclaredType().isInstance(p.x)
        ));

        assertThat(
            p.x.equals(p.y)
        )
        .as(
            "Expected IS_INSTANCE Equatables that are not instances of each other's declared type to not be equal. Actual: %n" +
                "    p.x: %s%n" +
                "    p.y: %s%n" +
                "    p.x.equals(p.y): %b%n" +
                "    p.x.getDeclaredType(): %s%n" +
                "    p.y.getDeclaredType(): %s%n" +
                "    p.x.getDeclaredType().isInstance(p.y): %b" +
                "    p.y.getDeclaredType().isInstance(p.x): %b" +
                "    p.x.getDeclaredType().isInstance(p.y) && p.y.getDeclaredType().isInstance(p.x)",
            p.x, p.y, p.x.equals(p.y),
            p.x.getDeclaredType(),
            p.y.getDeclaredType(),
            p.x.getDeclaredType().isInstance(p.y),
            p.y.getDeclaredType().isInstance(p.x),
            p.x.getDeclaredType().isInstance(p.y) && p.y.getDeclaredType().isInstance(p.x)
        )
        .isFalse();
    }

}
//@formatter:on

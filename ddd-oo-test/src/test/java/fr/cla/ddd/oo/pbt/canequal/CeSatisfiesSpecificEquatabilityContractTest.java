package fr.cla.ddd.oo.pbt.canequal;


import fr.cla.ddd.oo.pbt.EqualPair;
import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.PropertyCheck;
import fr.cla.ddd.oo.pbt.Value;
import fr.cla.ddd.oo.pbt.canequal.exampleequatables.CeVO1;
import fr.cla.ddd.oo.pbt.canequal.exampleequatables.CeVO1A;
import fr.cla.ddd.oo.pbt.canequal.generators.ArbitraryCes;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
public class CeSatisfiesSpecificEquatabilityContractTest
extends ArbitraryCes {

    @PropertyCheck
    public void when_equals_is_true_then_both_should_to_be_able_to_equal_each_others_declared_type(@ForAll("equalPairs") EqualPair p) {
        Assume.that(
            p.x.equals(p.y)
        );

        assertThat(
            p.x.canEqual(p.y)
            &&
            p.y.canEqual(p.x)
        )
        .as(
            "Expected equal CAN_EQUAL Equatables to be able to equal each other. Actual: %n" +
                "    p.x: %s%n" +
                "    p.y: %s%n" +
                "    p.x.equals(p.y): %b%n" +
                "    p.x.canEqual(p.y): %b" +
                "    p.y.canEqual(p.x): %b" +
                "    p.x.canEqual(p.y) && p.y.canEqual(p.x)",
            p.x, p.y, p.x.equals(p.y),
            p.x.canEqual(p.y),
            p.y.canEqual(p.x),
            p.x.canEqual(p.y) && p.y.canEqual(p.x)
        )
        .isTrue();
    }

    @PropertyCheck
    public void when_both_can_not_equal_each_other_then_equals_should_be_false(@ForAll("equatablePairs") EquatablePair p) {
        Assume.that(!(
            p.x.canEqual(p.y)
                &&
            p.y.canEqual(p.x)
        ));

        assertThat(
            p.x.equals(p.y)
        )
        .as(
            "Expected CAN_EQUAL Equatables that can not equal each other to not be equal. Actual: %n" +
                "    p.x: %s%n" +
                "    p.y: %s%n" +
                "    p.x.equals(p.y): %b%n" +
                "    p.x.canEqual(p.y): %b" +
                "    p.y.canEqual(p.x): %b" +
                "    p.x.canEqual(p.y) && p.y.canEqual(p.x)",
            p.x, p.y, p.x.equals(p.y),
            p.x.canEqual(p.y),
            p.y.canEqual(p.x),
            p.x.canEqual(p.y) && p.y.canEqual(p.x)
        )
        .isFalse();
    }

    @Test
    public void equatable_of_different_declared_type_can_sometimes_be_equal() {
        Value value = Value.random();
        CeVO1 ceVO1 = new CeVO1(value);
        CeVO1A ceVO1A = new CeVO1A(value);

        assertThat(ceVO1A.getDeclaredType()).isNotEqualTo(ceVO1.getDeclaredType());
        assertThat(ceVO1A).isEqualTo(ceVO1);
        assertThat(ceVO1).isEqualTo(ceVO1A);
    }

    @Test
    public void equatable_of_different_runtime_type_can_sometimes_be_equal() {
        Value value = Value.random();
        CeVO1 ceVO1 = new CeVO1(value);
        CeVO1A ceVO1A = new CeVO1A(value);

        assertThat(ceVO1A.getClass()).isNotEqualTo(ceVO1.getClass());
        assertThat(ceVO1A).isEqualTo(ceVO1);
        assertThat(ceVO1).isEqualTo(ceVO1A);
    }

}
//@formatter:on

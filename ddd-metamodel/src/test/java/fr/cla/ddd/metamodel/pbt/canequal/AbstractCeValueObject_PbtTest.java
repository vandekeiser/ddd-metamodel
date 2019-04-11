package fr.cla.ddd.metamodel.pbt.canequal;


import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import fr.cla.ddd.metamodel.pbt.VoPair;
import fr.cla.ddd.metamodel.pbt.VoSingleton;
import fr.cla.ddd.metamodel.pbt.VoTriplet;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

//@formatter:off
@RunWith(JUnitQuickcheck.class)
public class AbstractCeValueObject_PbtTest {

    private static final int TRIALS = 100_000;

    @Property(trials = TRIALS)
    public void equals_should_be_reflexive(@RandomCeVo VoSingleton s) {
        Assertions.assertThat(
            s.x.equals(s.x)
        ).isTrue();
    }

    @Property(trials = TRIALS)
    public void equals_should_be_symmetric(@RandomCeVoPair VoPair p) {
        assertThat(
            p.x.equals(p.y)
        ).isEqualTo(
            p.y.equals(p.x)
        );
    }

    @Property(trials = TRIALS)
    public void equals_should_be_transitive(@RandomCeVoTriplet VoTriplet t) {
        if(t.x.equals(t.y) && t.y.equals(t.z)){
            assertTrue(t.x.equals(t.z));
        }
    }

    @Property(trials = TRIALS)
    public void equals_null_should_be_false(@RandomCeVo VoSingleton s) {
        assertThat(
           s.x.equals(null)
        ).isFalse();
    }

    @Property(trials = TRIALS)
    public void equals_should_be_consistent(@RandomCeVoPair VoPair p) {
        assertThat(
            p.x.equals(p.y)
        ).isEqualTo(
            p.x.equals(p.y)
        );
    }

    @Property(trials = TRIALS)
    public void equals_implies_same_hashCode(@RandomCeVoPair VoPair p) {
        if(p.x.equals(p.y)){
            assertThat(
                p.x.hashCode()
            ).isEqualTo(
                p.y.hashCode()
            );
        }
    }

    @Property(trials = TRIALS)
    public void hashCode_should_be_consistent(@RandomCeVo VoSingleton s) {
        assertThat(
            s.x.hashCode()
        ).isEqualTo(
            s.x.hashCode()
        );
    }

    /**
     * Not part of the equals contract, but part of the Equatability.SAME_CONCRETE_CLASS contract.
     */
    @Property(trials = TRIALS)
    public void equals_should_be_false_for_different_types(@RandomCeVoPair VoPair p) {
        if(!p.x.equals(p.y)) return;

        assertThat(
            p.x.getClass().equals(p.y.getClass())
        )
        .as(
            "Expected only VOs of same time to be equal. Actual: %n" +
            "    p.x: %s%n" +
            "    p.y: %s%n" +
            "    p.x.equals(p.y): %b%n" +
            "    p.x.getClass(): %s%n" +
            "    p.y.getClass(): %s%n" +
            "    p.x.getClass().equals(p.y.getClass(): %b",
            p.x, p.y, p.x.equals(p.y),
            p.x.getClass(), p.y.getClass(), p.x.getClass().equals(p.y.getClass())
        )
        .isTrue();
    }

}
//@formatter:on

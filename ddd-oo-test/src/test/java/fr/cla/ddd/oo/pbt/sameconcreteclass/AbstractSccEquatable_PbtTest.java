package fr.cla.ddd.oo.pbt.sameconcreteclass;


import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.EquatableTriplet;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

import static fr.cla.ddd.oo.pbt.OoPbt.PROPERTY_TRIALS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

//@formatter:off
@RunWith(JUnitQuickcheck.class)
public class AbstractSccEquatable_PbtTest {

    private static final Logger log = Logger.getLogger(AbstractSccEquatable_PbtTest.class.getName());

    @Property(trials = PROPERTY_TRIALS)
    public void equals_should_be_reflexive(@RandomSccVo EquatableSingleton s) {
        log.fine(() -> s.toString());
        Assertions.assertThat(
            s.x.equals(s.x)
        ).isTrue();
    }

    @Property(trials = PROPERTY_TRIALS)
    public void equals_should_be_symmetric(@RandomSccVoPair EquatablePair p) {
        log.fine(() -> p.toString());
        assertThat(
            p.x.equals(p.y)
        ).isEqualTo(
            p.y.equals(p.x)
        );
    }

    @Property(trials = PROPERTY_TRIALS)
    public void equals_should_be_transitive(@RandomSccVoTriplet EquatableTriplet t) {
        log.fine(() -> t.toString());
        if(t.x.equals(t.y) && t.y.equals(t.z)){
            assertTrue(t.x.equals(t.z));
        }
    }

    @Property(trials = PROPERTY_TRIALS)
    public void equals_null_should_be_false(@RandomSccVo EquatableSingleton s) {
        log.fine(() -> s.toString());
        assertThat(
           s.x.equals(null)
        ).isFalse();
    }

    @Property(trials = PROPERTY_TRIALS)
    public void equals_should_be_consistent(@RandomSccVoPair EquatablePair p) {
        log.fine(() -> p.toString());
        assertThat(
            p.x.equals(p.y)
        ).isEqualTo(
            p.x.equals(p.y)
        );
    }

    @Property(trials = PROPERTY_TRIALS)
    public void equals_implies_same_hashCode(@RandomSccVoPair EquatablePair p) {
        log.fine(() -> p.toString());
        if(p.x.equals(p.y)){
            assertThat(
                p.x.hashCode()
            ).isEqualTo(
                p.y.hashCode()
            );
        }
    }

    @Property(trials = PROPERTY_TRIALS)
    public void hashCode_should_be_consistent(@RandomSccVo EquatableSingleton s) {
        log.fine(() -> s.toString());
        assertThat(
            s.x.hashCode()
        ).isEqualTo(
            s.x.hashCode()
        );
    }

    /**
     * Not part of the equals contract, but part of the Equatability.SAME_CONCRETE_CLASS contract.
     */
    @Property(trials = PROPERTY_TRIALS)
    public void equals_should_be_false_for_different_types(@RandomSccVoPair EquatablePair p) {
        log.fine(() -> p.toString());
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

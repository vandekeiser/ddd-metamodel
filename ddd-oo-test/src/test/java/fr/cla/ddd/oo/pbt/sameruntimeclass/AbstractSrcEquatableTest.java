package fr.cla.ddd.oo.pbt.sameruntimeclass;


import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.EquatableTriplet;
import fr.cla.ddd.oo.pbt.PropertyCheck;
import net.jqwik.api.ForAll;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
public class AbstractSrcEquatableTest
extends ArbitrarySrcEquatables {

    private static final Logger log = Logger.getLogger(AbstractSrcEquatableTest.class.getName());

    @PropertyCheck
    public void equals_should_be_reflexive(@ForAll("equatableSingletons") EquatableSingleton s) {
        log.fine(() -> s.toString());
        assertThat(
            s.x.equals(s.x)
        ).isTrue();
    }


    @PropertyCheck
    public void equals_should_be_symmetric(@ForAll("equatablePairs") EquatablePair p) {
        log.fine(() -> p.toString());
        assertThat(
            p.x.equals(p.y)
        ).isEqualTo(
            p.y.equals(p.x)
        );
    }

    @PropertyCheck
    public void equals_should_be_transitive(@ForAll("equatableTriplets") EquatableTriplet t) {
        log.fine(() -> t.toString());
        if(t.x.equals(t.y) && t.y.equals(t.z)){
            assertThat(
                t.x.equals(t.z)
            ).isTrue();
        }
    }

    @PropertyCheck
    public void equals_null_should_be_false(@ForAll("equatableSingletons") EquatableSingleton s) {
        log.fine(() -> s.toString());
        assertThat(
           s.x.equals(null)
        ).isFalse();
    }

    @PropertyCheck
    public void equals_should_be_consistent(@ForAll("equatablePairs") EquatablePair p) {
        log.fine(() -> p.toString());
        assertThat(
            p.x.equals(p.y)
        ).isEqualTo(
            p.x.equals(p.y)
        );
    }

    @PropertyCheck
    public void equals_implies_same_hashCode(@ForAll("equatablePairs") EquatablePair p) {
        log.fine(() -> p.toString());
        if(p.x.equals(p.y)){
            assertThat(
                p.x.hashCode()
            ).isEqualTo(
                p.y.hashCode()
            );
        }
    }

    @PropertyCheck
    public void hashCode_should_be_consistent(@ForAll("equatableSingletons") EquatableSingleton s) {
        log.fine(() -> s.toString());
        assertThat(
            s.x.hashCode()
        ).isEqualTo(
            s.x.hashCode()
        );
    }

    /**
     * Not part of the equals contract, but part of the Equatability.SAME_RUNTIME_CLASS contract.
     */
    @PropertyCheck
    public void equals_should_be_false_for_different_types(@ForAll("equatablePairs") EquatablePair p) {
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

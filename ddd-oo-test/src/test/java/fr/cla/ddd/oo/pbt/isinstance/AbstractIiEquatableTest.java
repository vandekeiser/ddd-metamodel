package fr.cla.ddd.oo.pbt.isinstance;


import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.EquatableTriplet;
import fr.cla.ddd.oo.pbt.PropertyCheck;
import net.jqwik.api.ForAll;
import org.assertj.core.api.Assertions;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@formatter:off
public class AbstractIiEquatableTest
extends ArbitraryIiEquatables {

    private static final Logger log = Logger.getLogger(AbstractIiEquatableTest.class.getName());

    @PropertyCheck
    public void equals_should_be_reflexive(@ForAll("equatableSingletons") EquatableSingleton s) {
        log.fine(() -> s.toString());
        Assertions.assertThat(
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
            assertTrue(t.x.equals(t.z));
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

}
//@formatter:on

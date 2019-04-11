package fr.cla.ddd.metamodel.pbt.canequal;


import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import fr.cla.ddd.metamodel.examplevos.canequal.CeVO1;
import fr.cla.ddd.metamodel.examplevos.canequal.CeVO1A;
import fr.cla.ddd.metamodel.pbt.VoPair;
import fr.cla.ddd.metamodel.pbt.VoSingleton;
import fr.cla.ddd.metamodel.pbt.VoTriplet;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

//@formatter:off
@RunWith(JUnitQuickcheck.class)
public class AbstractCeValueObject_PbtTest {

    private static final Logger log = Logger.getLogger(AbstractCeValueObject_PbtTest.class.getName());
    private static final int TRIALS = 100_000;

    @Property(trials = TRIALS)
    public void equals_should_be_reflexive(@RandomCeVo VoSingleton s) {
        log.fine(() -> s.toString());
        Assertions.assertThat(
            s.x.equals(s.x)
        ).isTrue();
    }

    @Property(trials = TRIALS)
    public void equals_should_be_symmetric(@RandomCeVoPair VoPair p) {
        log.fine(() -> p.toString());
        assertThat(
            p.x.equals(p.y)
        ).isEqualTo(
            p.y.equals(p.x)
        );
    }

    @Property(trials = TRIALS)
    public void equals_should_be_transitive(@RandomCeVoTriplet VoTriplet t) {
        log.fine(() -> t.toString());
        if(t.x.equals(t.y) && t.y.equals(t.z)){
            assertTrue(t.x.equals(t.z));
        }
    }

    @Property(trials = TRIALS)
    public void equals_null_should_be_false(@RandomCeVo VoSingleton s) {
        log.fine(() -> s.toString());
        assertThat(
           s.x.equals(null)
        ).isFalse();
    }

    @Property(trials = TRIALS)
    public void equals_should_be_consistent(@RandomCeVoPair VoPair p) {
        log.fine(() -> p.toString());
        assertThat(
            p.x.equals(p.y)
        ).isEqualTo(
            p.x.equals(p.y)
        );
    }

    @Property(trials = TRIALS)
    public void equals_implies_same_hashCode(@RandomCeVoPair VoPair p) {
        log.fine(() -> p.toString());
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
        log.fine(() -> s.toString());
        assertThat(
            s.x.hashCode()
        ).isEqualTo(
            s.x.hashCode()
        );
    }

}
//@formatter:on

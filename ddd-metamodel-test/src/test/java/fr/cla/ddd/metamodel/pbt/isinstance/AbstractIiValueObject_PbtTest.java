package fr.cla.ddd.metamodel.pbt.isinstance;


import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import fr.cla.ddd.metamodel.pbt.VoPair;
import fr.cla.ddd.metamodel.pbt.VoSingleton;
import fr.cla.ddd.metamodel.pbt.VoTriplet;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

import static fr.cla.ddd.metamodel.pbt.MetamodelPbt.PROPERTY_TRIALS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

//@formatter:off
@RunWith(JUnitQuickcheck.class)
public class AbstractIiValueObject_PbtTest {

    private static final Logger log = Logger.getLogger(AbstractIiValueObject_PbtTest.class.getName());

    @Property(trials = PROPERTY_TRIALS)
    public void equals_should_be_reflexive(@RandomIiVo VoSingleton s) {
        log.fine(() -> s.toString());
        Assertions.assertThat(
            s.x.equals(s.x)
        ).isTrue();
    }

    @Property(trials = PROPERTY_TRIALS)
    public void equals_should_be_symmetric(@RandomIiVoPair VoPair p) {
        log.fine(() -> p.toString());
        assertThat(
            p.x.equals(p.y)
        ).isEqualTo(
            p.y.equals(p.x)
        );
    }

    @Property(trials = PROPERTY_TRIALS)
    public void equals_should_be_transitive(@RandomIiVoTriplet VoTriplet t) {
        log.fine(() -> t.toString());
        if(t.x.equals(t.y) && t.y.equals(t.z)){
            assertTrue(t.x.equals(t.z));
        }
    }

    @Property(trials = PROPERTY_TRIALS)
    public void equals_null_should_be_false(@RandomIiVo VoSingleton s) {
        log.fine(() -> s.toString());
        assertThat(
           s.x.equals(null)
        ).isFalse();
    }

    @Property(trials = PROPERTY_TRIALS)
    public void equals_should_be_consistent(@RandomIiVoPair VoPair p) {
        log.fine(() -> p.toString());
        assertThat(
            p.x.equals(p.y)
        ).isEqualTo(
            p.x.equals(p.y)
        );
    }

    @Property(trials = PROPERTY_TRIALS)
    public void equals_implies_same_hashCode(@RandomIiVoPair VoPair p) {
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
    public void hashCode_should_be_consistent(@RandomIiVo VoSingleton s) {
        log.fine(() -> s.toString());
        assertThat(
            s.x.hashCode()
        ).isEqualTo(
            s.x.hashCode()
        );
    }

}
//@formatter:on

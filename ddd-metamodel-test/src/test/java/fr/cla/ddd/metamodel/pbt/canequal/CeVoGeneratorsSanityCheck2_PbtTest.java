package fr.cla.ddd.metamodel.pbt.canequal;


import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import fr.cla.ddd.metamodel.pbt.VoPair;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

import static fr.cla.ddd.metamodel.pbt.MetamodelPbt.SANITY_CHECK_TRIALS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.assumeThat;

//@formatter:off
@RunWith(JUnitQuickcheck.class)
public class CeVoGeneratorsSanityCheck2_PbtTest {

    private static final Logger log = Logger.getLogger(CeVoGeneratorsSanityCheck2_PbtTest.class.getName());

    @Property(trials = SANITY_CHECK_TRIALS)
    public void random_pairs_should_sometimes_contain_xy_of_same_type(
        @RandomCeVoPair VoPair p
    ) {
        log.fine(() -> p.toString());
        random_pairs_should_sometimes_contain_xy_of_type0(p, true);
    }
    @Property(trials = SANITY_CHECK_TRIALS)
    public void random_pairs_should_sometimes_contain_xy_of_different_types(
        @RandomCeVoPair VoPair p
    ) {
        log.fine(() -> p.toString());
        random_pairs_should_sometimes_contain_xy_of_type0(p, true);
    }
    private void random_pairs_should_sometimes_contain_xy_of_type0(
        VoPair p, boolean should
    ) {
        assumeThat(p.x.getClass().equals(p.y.getClass()), is(should));
    }

    @Property(trials = SANITY_CHECK_TRIALS)
    public void random_pairs_should_sometimes_contain_xy_of_related_types(
        @RandomCeVoPair VoPair p
    ) {
        log.fine(() -> p.toString());
        random_pairs_should_sometimes_contain_xy_of_related_types0(p, true);
    }
    @Property(trials = SANITY_CHECK_TRIALS)
    public void random_pairs_should_sometimes_contain_xy_of_unrelated_types(
        @RandomCeVoPair VoPair p
    ) {
        log.fine(() -> p.toString());
        random_pairs_should_sometimes_contain_xy_of_related_types0(p, true);
    }
    private void random_pairs_should_sometimes_contain_xy_of_related_types0(
        VoPair p, boolean should
    ) {
        assumeThat(p.x.getClass().isAssignableFrom(p.y.getClass()), is(should));
    }

}
//@formatter:on

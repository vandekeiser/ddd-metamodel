package fr.cla.ddd.oo.pbt.isinstance;


import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import fr.cla.ddd.oo.pbt.VoPair;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.assumeThat;

//@formatter:off
@RunWith(JUnitQuickcheck.class)
public class IiVoGeneratorsSanityCheck2_PbtTest {

    private static final Logger log = Logger.getLogger(IiVoGeneratorsSanityCheck2_PbtTest.class.getName());
    private static final int TRIALS = 10_000;

    @Property(trials = TRIALS)
    public void random_pairs_should_sometimes_contain_xy_of_same_type(
        @RandomIiVoPair VoPair p
    ) {
        log.fine(() -> p.toString());
        random_pairs_should_sometimes_contain_xy_of_type0(p, true);
    }
    @Property(trials = TRIALS)
    public void random_pairs_should_sometimes_contain_xy_of_different_types(
        @RandomIiVoPair VoPair p
    ) {
        log.fine(() -> p.toString());
        random_pairs_should_sometimes_contain_xy_of_type0(p, true);
    }
    private void random_pairs_should_sometimes_contain_xy_of_type0(
        VoPair p, boolean should
    ) {
        assumeThat(p.x.getClass().equals(p.y.getClass()), is(should));
    }

    @Property(trials = TRIALS)
    public void random_pairs_should_sometimes_contain_xy_of_related_types(
        @RandomIiVoPair VoPair p
    ) {
        log.fine(() -> p.toString());
        random_pairs_should_sometimes_contain_xy_of_related_types0(p, true);
    }
    @Property(trials = TRIALS)
    public void random_pairs_should_sometimes_contain_xy_of_unrelated_types(
        @RandomIiVoPair VoPair p
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

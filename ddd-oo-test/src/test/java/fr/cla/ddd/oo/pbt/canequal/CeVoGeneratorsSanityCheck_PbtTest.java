package fr.cla.ddd.oo.pbt.canequal;


import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.EquatableTriplet;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

import static fr.cla.ddd.oo.pbt.SanityCheck.SANITY_CHECK_TRIALS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.assumeThat;

//@formatter:off
@RunWith(JUnitQuickcheck.class)
public class CeVoGeneratorsSanityCheck_PbtTest {

    private static final Logger log = Logger.getLogger(CeVoGeneratorsSanityCheck_PbtTest.class.getName());

    @Property(trials = SANITY_CHECK_TRIALS)
    public void random_pairs_should_sometimes_contain_equal_xy(
        @RandomCeVoPair EquatablePair p
    ) {
        log.fine(() -> p.toString());
        random_pairs_should_sometimes_contain_equal_xy0(p, true);
    }
    @Property(trials = SANITY_CHECK_TRIALS)
    public void random_pairs_should_sometimes_contain_not_equal_xy(
        @RandomCeVoPair EquatablePair p
    ) {
        log.fine(() -> p.toString());
        random_pairs_should_sometimes_contain_equal_xy0(p, true);
    }
    private void random_pairs_should_sometimes_contain_equal_xy0(
        EquatablePair p, boolean should
    ) {
        assumeThat(p.x.equals(p.y), is(should));
    }

    @Property(trials = SANITY_CHECK_TRIALS)
    public void random_triplets_should_sometimes_contain_equal_xy(
        @RandomCeVoTriplet EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_xy0(t, true);
    }
    @Property(trials = SANITY_CHECK_TRIALS)
    public void random_triplets_should_sometimes_not_contain_equal_xy(
        @RandomCeVoTriplet EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_xy0(t, false);
    }
    private void random_triplets_should_sometimes_contain_equal_xy0(
        EquatableTriplet t, boolean should
    ) {
        assumeThat(t.x.equals(t.y), is(should));
    }

    @Property(trials = SANITY_CHECK_TRIALS)
    public void random_triplets_should_sometimes_contain_equal_yz(
        @RandomCeVoTriplet EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_yz0(t, true);
    }
    @Property(trials = SANITY_CHECK_TRIALS)
    public void random_triplets_should_sometimes_not_contain_equal_yz(
        @RandomCeVoTriplet EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_yz0(t, false);
    }
    private void random_triplets_should_sometimes_contain_equal_yz0(
        EquatableTriplet t, boolean should
    ) {
        assumeThat(t.y.equals(t.z), is(should));
    }

    @Property(trials = SANITY_CHECK_TRIALS)
    public void random_triplets_should_sometimes_contain_equal_xz(
        @RandomCeVoTriplet EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_xz0(t, true);
    }
    @Property(trials = SANITY_CHECK_TRIALS)
    public void random_triplets_should_sometimes_not_contain_equal_xz(
        @RandomCeVoTriplet EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_xz0(t, false);
    }
    private void random_triplets_should_sometimes_contain_equal_xz0(
        EquatableTriplet t, boolean should
    ) {
        assumeThat(t.x.equals(t.z), is(should));
    }

    @Property(trials = SANITY_CHECK_TRIALS)
    public void random_triplets_should_sometimes_contain_equal_xyz(
        @RandomCeVoTriplet EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_xyz0(t, true);
    }
    @Property(trials = SANITY_CHECK_TRIALS)
    public void random_triplets_should_sometimes_not_contain_equal_xyz(
        @RandomCeVoTriplet EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_xyz0(t, false);
    }
    private void random_triplets_should_sometimes_contain_equal_xyz0(
        EquatableTriplet t, boolean should
    ) {
        assumeThat(t.x.equals(t.y) && t.y.equals(t.z), is(should));
    }

}
//@formatter:on

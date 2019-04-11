package fr.cla.ddd.metamodel.pbt.canequal;


import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import fr.cla.ddd.metamodel.pbt.VoPair;
import fr.cla.ddd.metamodel.pbt.VoTriplet;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.assumeThat;

//@formatter:off
@RunWith(JUnitQuickcheck.class)
public class CeVoGeneratorsSanityCheck_PbtTest {

    private static final int TRIALS = 10_000;

    @Property(trials = TRIALS)
    public void random_pairs_should_sometimes_contain_equal_xy(
        @RandomCeVoPair VoPair p
    ) {
        random_pairs_should_sometimes_contain_equal_xy0(p, true);
    }
    @Property(trials = TRIALS)
    public void random_pairs_should_sometimes_contain_not_equal_xy(
        @RandomCeVoPair VoPair p
    ) {
        random_pairs_should_sometimes_contain_equal_xy0(p, true);
    }
    private void random_pairs_should_sometimes_contain_equal_xy0(
        VoPair p, boolean should
    ) {
        assumeThat(p.x.equals(p.y), is(should));
    }

    @Property(trials = TRIALS)
    public void random_triplets_should_sometimes_contain_equal_xy(
        @RandomCeVoTriplet VoTriplet t
    ) {
        random_triplets_should_sometimes_contain_equal_xy0(t, true);
    }
    @Property(trials = TRIALS)
    public void random_triplets_should_sometimes_not_contain_equal_xy(
        @RandomCeVoTriplet VoTriplet t
    ) {
        random_triplets_should_sometimes_contain_equal_xy0(t, false);
    }
    private void random_triplets_should_sometimes_contain_equal_xy0(
        VoTriplet t, boolean should
    ) {
        assumeThat(t.x.equals(t.y), is(should));
    }

    @Property(trials = TRIALS)
    public void random_triplets_should_sometimes_contain_equal_yz(
        @RandomCeVoTriplet VoTriplet t
    ) {
        random_triplets_should_sometimes_contain_equal_yz0(t, true);
    }
    @Property(trials = TRIALS)
    public void random_triplets_should_sometimes_not_contain_equal_yz(
        @RandomCeVoTriplet VoTriplet t
    ) {
        random_triplets_should_sometimes_contain_equal_yz0(t, false);
    }
    private void random_triplets_should_sometimes_contain_equal_yz0(
        VoTriplet t, boolean should
    ) {
        assumeThat(t.y.equals(t.z), is(should));
    }

    @Property(trials = TRIALS)
    public void random_triplets_should_sometimes_contain_equal_xz(
        @RandomCeVoTriplet VoTriplet t
    ) {
        random_triplets_should_sometimes_contain_equal_xz0(t, true);
    }
    @Property(trials = TRIALS)
    public void random_triplets_should_sometimes_not_contain_equal_xz(
        @RandomCeVoTriplet VoTriplet t
    ) {
        random_triplets_should_sometimes_contain_equal_xz0(t, false);
    }
    private void random_triplets_should_sometimes_contain_equal_xz0(
        VoTriplet t, boolean should
    ) {
        assumeThat(t.x.equals(t.z), is(should));
    }

    @Property(trials = TRIALS)
    public void random_triplets_should_sometimes_contain_equal_xyz(
        @RandomCeVoTriplet VoTriplet t
    ) {
        random_triplets_should_sometimes_contain_equal_xyz0(t, true);
    }
    @Property(trials = TRIALS)
    public void random_triplets_should_sometimes_not_contain_equal_xyz(
        @RandomCeVoTriplet VoTriplet t
    ) {
        random_triplets_should_sometimes_contain_equal_xyz0(t, false);
    }
    private void random_triplets_should_sometimes_contain_equal_xyz0(
        VoTriplet t, boolean should
    ) {
        assumeThat(t.x.equals(t.y) && t.y.equals(t.z), is(should));
    }

}
//@formatter:on

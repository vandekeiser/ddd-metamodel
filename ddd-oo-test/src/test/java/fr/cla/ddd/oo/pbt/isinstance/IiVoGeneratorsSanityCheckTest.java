package fr.cla.ddd.oo.pbt.isinstance;


import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.EquatableTriplet;
import fr.cla.ddd.oo.pbt.SanityCheck;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;

import java.util.logging.Logger;

//@formatter:off
public class IiVoGeneratorsSanityCheckTest
extends ArbitraryIiEquatables {

    private static final Logger log = Logger.getLogger(IiVoGeneratorsSanityCheckTest.class.getName());

    @SanityCheck
    public void random_pairs_should_sometimes_contain_equal_xy(
        @ForAll("equatablePairs") EquatablePair p
    ) {
        log.fine(() -> p.toString());
        random_pairs_should_sometimes_contain_equal_xy0(p, true);
    }
    @SanityCheck
    public void random_pairs_should_sometimes_contain_not_equal_xy(
        @ForAll("equatablePairs") EquatablePair p
    ) {
        log.fine(() -> p.toString());
        random_pairs_should_sometimes_contain_equal_xy0(p, true);
    }
    private void random_pairs_should_sometimes_contain_equal_xy0(
        EquatablePair p, boolean should
    ) {
        Assume.that(p.x.equals(p.y) == should);
    }

    @SanityCheck
    public void random_triplets_should_sometimes_contain_equal_xy(
        @ForAll("equatableTriplets") EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_xy0(t, true);
    }
    @SanityCheck
    public void random_triplets_should_sometimes_not_contain_equal_xy(
        @ForAll("equatableTriplets") EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_xy0(t, false);
    }
    private void random_triplets_should_sometimes_contain_equal_xy0(
        EquatableTriplet t, boolean should
    ) {
        Assume.that(t.x.equals(t.y) == should);
    }

    @SanityCheck
    public void random_triplets_should_sometimes_contain_equal_yz(
        @ForAll("equatableTriplets") EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_yz0(t, true);
    }
    @SanityCheck
    public void random_triplets_should_sometimes_not_contain_equal_yz(
        @ForAll("equatableTriplets") EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_yz0(t, false);
    }
    private void random_triplets_should_sometimes_contain_equal_yz0(
        EquatableTriplet t, boolean should
    ) {
        Assume.that(t.y.equals(t.z) == should);
    }

    @SanityCheck
    public void random_triplets_should_sometimes_contain_equal_xz(
        @ForAll("equatableTriplets") EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_xz0(t, true);
    }
    @SanityCheck
    public void random_triplets_should_sometimes_not_contain_equal_xz(
        @ForAll("equatableTriplets") EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_xz0(t, false);
    }
    private void random_triplets_should_sometimes_contain_equal_xz0(
        EquatableTriplet t, boolean should
    ) {
        Assume.that(t.x.equals(t.z) == should);
    }

    @SanityCheck
    public void random_triplets_should_sometimes_contain_equal_xyz(
        @ForAll("equatableTriplets") EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_xyz0(t, true);
    }
    @SanityCheck
    public void random_triplets_should_sometimes_not_contain_equal_xyz(
        @ForAll("equatableTriplets") EquatableTriplet t
    ) {
        log.fine(() -> t.toString());
        random_triplets_should_sometimes_contain_equal_xyz0(t, false);
    }
    private void random_triplets_should_sometimes_contain_equal_xyz0(
        EquatableTriplet t, boolean should
    ) {
        Assume.that(t.x.equals(t.y) && t.y.equals(t.z) == should);
    }

}
//@formatter:on

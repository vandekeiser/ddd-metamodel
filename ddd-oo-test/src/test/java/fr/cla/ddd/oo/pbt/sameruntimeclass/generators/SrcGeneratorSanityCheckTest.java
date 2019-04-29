package fr.cla.ddd.oo.pbt.sameruntimeclass.generators;


import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.EquatableTriplet;
import fr.cla.ddd.oo.pbt.SanityCheck;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;


public class SrcGeneratorSanityCheckTest
    extends ArbitrarySrcs {

    @SanityCheck
    public void random_pairs_should_sometimes_contain_equal_xy(
        @ForAll("equatablePairs") EquatablePair p
    ) {
        random_pairs_should_sometimes_contain_equal_xy0(p, true);
    }
    @SanityCheck
    public void random_pairs_should_sometimes_contain_not_equal_xy(
        @ForAll("equatablePairs") EquatablePair p
    ) {
        random_pairs_should_sometimes_contain_equal_xy0(p, false);
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
        random_triplets_should_sometimes_contain_equal_xy0(t, true);
    }
    @SanityCheck
    public void random_triplets_should_sometimes_not_contain_equal_xy(
        @ForAll("equatableTriplets") EquatableTriplet t
    ) {
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
        random_triplets_should_sometimes_contain_equal_yz0(t, true);
    }
    @SanityCheck
    public void random_triplets_should_sometimes_not_contain_equal_yz(
        @ForAll("equatableTriplets") EquatableTriplet t
    ) {
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
        random_triplets_should_sometimes_contain_equal_xz0(t, true);
    }
    @SanityCheck
    public void random_triplets_should_sometimes_not_contain_equal_xz(
        @ForAll("equatableTriplets") EquatableTriplet t
    ) {
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
        random_triplets_should_sometimes_contain_equal_xyz0(t, true);
    }
    @SanityCheck
    public void random_triplets_should_sometimes_not_contain_equal_xyz(
        @ForAll("equatableTriplets") EquatableTriplet t
    ) {
        random_triplets_should_sometimes_contain_equal_xyz0(t, false);
    }
    private void random_triplets_should_sometimes_contain_equal_xyz0(
        EquatableTriplet t, boolean should
    ) {
        Assume.that(t.x.equals(t.y) && t.y.equals(t.z) == should);
    }

    @SanityCheck
    public void random_pairs_should_sometimes_contain_xy_of_same_type(
        @ForAll("equatablePairs") EquatablePair p
    ) {
        random_pairs_should_sometimes_contain_xy_of_type0(p, true);
    }
    @SanityCheck
    public void random_pairs_should_sometimes_contain_xy_of_different_types(
        @ForAll("equatablePairs") EquatablePair p
    ) {
        random_pairs_should_sometimes_contain_xy_of_type0(p, false);
    }
    private void random_pairs_should_sometimes_contain_xy_of_type0(
        EquatablePair p, boolean should
    ) {
        Assume.that(p.x.getClass().equals(p.y.getClass()) == should);
    }

    @SanityCheck
    public void random_pairs_should_sometimes_contain_xy_of_related_types(
        @ForAll("equatablePairs") EquatablePair p
    ) {
        random_pairs_should_sometimes_contain_xy_of_related_types0(p, true);
    }
    @SanityCheck
    public void random_pairs_should_sometimes_contain_xy_of_unrelated_types(
        @ForAll("equatablePairs") EquatablePair p
    ) {
        random_pairs_should_sometimes_contain_xy_of_related_types0(p, false);
    }
    private void random_pairs_should_sometimes_contain_xy_of_related_types0(
        EquatablePair p, boolean should
    ) {
        Assume.that(p.x.getClass().isAssignableFrom(p.y.getClass()) == should);
    }

}


package fr.cla.ddd.oo.pbt.samedeclaredclass;


import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.SanityCheck;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;

import java.util.logging.Logger;

//@formatter:off
public class SdcVoGeneratorsSanityCheckTest
extends ArbitrarySdcEquatables {

    private static final Logger log = Logger.getLogger(SdcVoGeneratorsSanityCheckTest.class.getName());

    @SanityCheck
    public void random_pairs_should_sometimes_contain_xy_of_same_type(
        @ForAll("equatablePairs") EquatablePair p
    ) {
        log.fine(() -> p.toString());
        random_pairs_should_sometimes_contain_xy_of_type0(p, true);
    }
    @SanityCheck
    public void random_pairs_should_sometimes_contain_xy_of_different_types(
        @ForAll("equatablePairs") EquatablePair p
    ) {
        log.fine(() -> p.toString());
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
        log.fine(() -> p.toString());
        random_pairs_should_sometimes_contain_xy_of_related_types0(p, true);
    }
    @SanityCheck
    public void random_pairs_should_sometimes_contain_xy_of_unrelated_types(
        @ForAll("equatablePairs") EquatablePair p
    ) {
        log.fine(() -> p.toString());
        random_pairs_should_sometimes_contain_xy_of_related_types0(p, false);
    }
    private void random_pairs_should_sometimes_contain_xy_of_related_types0(
        EquatablePair p, boolean should
    ) {
        Assume.that(p.x.getClass().equals(p.y.getClass()) == should);
    }

}
//@formatter:on

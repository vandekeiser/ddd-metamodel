package fr.cla.ddd.oo.pbt.sameruntimeclass;


import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.EquatableTriplet;
import net.jqwik.api.*;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
public class ArbitrarySrcEquatables {

    @Provide
    Arbitrary<EquatableSingleton> equatableSingletons() {
        return Arbitraries.create(SrcVoGenerator::generate);
    }

    @Provide
    Arbitrary<EquatablePair> equatablePairs() {
        return Arbitraries.create(SrcVoPairGenerator::generate);
    }

    @Provide
    Arbitrary<EquatableTriplet> equatableTriplets() {
        return Arbitraries.create(SrcVoTripletGenerator::generate);
    }

}
//@formatter:on

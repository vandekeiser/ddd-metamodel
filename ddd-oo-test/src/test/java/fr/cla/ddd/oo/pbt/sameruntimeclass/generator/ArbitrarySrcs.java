package fr.cla.ddd.oo.pbt.sameruntimeclass.generator;


import fr.cla.ddd.oo.pbt.EqualPair;
import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.EquatableTriplet;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Provide;

//@formatter:off
public class ArbitrarySrcs {

    @Provide
    Arbitrary<EquatableSingleton> equatableSingletons() {
        return Arbitraries.create(SrcGenerator::generate);
    }

    @Provide
    Arbitrary<EquatablePair> equatablePairs() {
        return Arbitraries.create(SrcPairGenerator::generate);
    }

    @Provide
    Arbitrary<EqualPair> equalPairs() {
        return Arbitraries.create(SrcEqualPairGenerator::generate);
    }

    @Provide
    Arbitrary<EquatableTriplet> equatableTriplets() {
        return Arbitraries.create(SrcTripletGenerator::generate);
    }

}
//@formatter:on

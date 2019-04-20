package fr.cla.ddd.oo.pbt.samedeclaredclass.generator;


import fr.cla.ddd.oo.pbt.EqualPair;
import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.EquatableTriplet;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Provide;

//@formatter:off
public class ArbitrarySdcs {

    @Provide
    Arbitrary<EquatableSingleton> equatableSingletons() {
        return Arbitraries.create(SdcGenerator::generate);
    }

    @Provide
    Arbitrary<EquatablePair> equatablePairs() {
        return Arbitraries.create(SdcPairGenerator::generate);
    }

    @Provide
    Arbitrary<EqualPair> equalPairs() {
        return Arbitraries.create(SdcEqualPairGenerator::generate);
    }

    @Provide
    Arbitrary<EquatableTriplet> equatableTriplets() {
        return Arbitraries.create(SdcTripletGenerator::generate);
    }

}
//@formatter:on

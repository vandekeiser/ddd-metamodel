package fr.cla.ddd.oo.pbt.canequal;


import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.EquatableTriplet;
import fr.cla.ddd.oo.pbt.isinstance.IiVoPairGenerator;
import fr.cla.ddd.oo.pbt.isinstance.IiVoTripletGenerator;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Provide;

//@formatter:off
public class ArbitraryCeEquatables {

    @Provide
    Arbitrary<EquatableSingleton> equatableSingletons() {
        return Arbitraries.create(CeVoGenerator::generate);
    }

    @Provide
    Arbitrary<EquatablePair> equatablePairs() {
        return Arbitraries.create(IiVoPairGenerator::generate);
    }

    @Provide
    Arbitrary<EquatableTriplet> equatableTriplets() {
        return Arbitraries.create(IiVoTripletGenerator::generate);
    }

}
//@formatter:on

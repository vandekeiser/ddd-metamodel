package fr.cla.ddd.oo.pbt.isinstance;


import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.EquatableTriplet;
import fr.cla.ddd.oo.pbt.sameconcreteclass.SccVoGenerator;
import fr.cla.ddd.oo.pbt.sameconcreteclass.SccVoPairGenerator;
import fr.cla.ddd.oo.pbt.sameconcreteclass.SccVoTripletGenerator;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Provide;

//@formatter:off
public class ArbitraryIiEquatables {

    @Provide
    Arbitrary<EquatableSingleton> equatableSingletons() {
        return Arbitraries.create(IiVoGenerator::generate);
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

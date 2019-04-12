package fr.cla.ddd.oo.pbt.sameconcreteclass;


import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.EquatableTriplet;
import net.jqwik.api.*;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
public class ArbitrarySccEquatablesX {

    @Provide
    Arbitrary<EquatableSingleton> equatableSingletons() {
        return Arbitraries.create(SccVoGeneratorX::generate);
    }

    @Provide
    Arbitrary<EquatablePair> equatablePairs() {
        return Arbitraries.create(SccVoPairGeneratorX::generate);
    }

    @Provide
    Arbitrary<EquatableTriplet> equatableTriplets() {
        return Arbitraries.create(SccVoTripletGeneratorX::generate);
    }

}
//@formatter:on

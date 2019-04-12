package fr.cla.ddd.oo.pbt.sameconcreteclass;

import fr.cla.ddd.oo.pbt.EquatablePair;

//@formatter:off
public class SccVoPairGeneratorX {

    public static EquatablePair generate() {
        return new EquatablePair(
            SccVoGeneratorX.generateValue(),
            SccVoGeneratorX.generateValue()
        );
    }

}
//@formatter:on
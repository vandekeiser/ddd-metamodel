package fr.cla.ddd.oo.pbt.sameconcreteclass;

import fr.cla.ddd.oo.pbt.EquatablePair;

//@formatter:off
public class SccVoPairGenerator {

    public static EquatablePair generate() {
        return new EquatablePair(
            SccVoGenerator.generateValue(),
            SccVoGenerator.generateValue()
        );
    }

}
//@formatter:on
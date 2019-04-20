package fr.cla.ddd.oo.pbt.canequal.generator;

import fr.cla.ddd.oo.pbt.EquatablePair;

//@formatter:off
public class CePairGenerator {

    public static EquatablePair generate() {
        return new EquatablePair(
            CeGenerator.generateValue(),
            CeGenerator.generateValue()
        );
    }

}
//@formatter:on
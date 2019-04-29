package fr.cla.ddd.oo.pbt.canequal.generators;

import fr.cla.ddd.oo.pbt.EquatablePair;


public class CePairGenerator {

    public static EquatablePair generate() {
        return new EquatablePair(
            CeGenerator.generateValue(),
            CeGenerator.generateValue()
        );
    }

}

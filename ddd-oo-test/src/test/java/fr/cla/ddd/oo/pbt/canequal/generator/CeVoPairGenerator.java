package fr.cla.ddd.oo.pbt.canequal.generator;

import fr.cla.ddd.oo.pbt.EquatablePair;

//@formatter:off
public class CeVoPairGenerator {

    public static EquatablePair generate() {
        return new EquatablePair(
            CeVoGenerator.generateValue(),
            CeVoGenerator.generateValue()
        );
    }

}
//@formatter:on
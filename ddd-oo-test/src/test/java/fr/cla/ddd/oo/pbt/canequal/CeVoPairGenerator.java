package fr.cla.ddd.oo.pbt.canequal;

import fr.cla.ddd.oo.pbt.EquatablePair;

//@formatter:off
public class CeVoPairGenerator {

    public EquatablePair generate() {
        return new EquatablePair(
            CeVoGenerator.generateValue(),
            CeVoGenerator.generateValue()
        );
    }

}
//@formatter:on
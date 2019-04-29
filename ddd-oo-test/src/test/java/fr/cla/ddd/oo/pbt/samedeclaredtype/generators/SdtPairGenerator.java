package fr.cla.ddd.oo.pbt.samedeclaredtype.generators;

import fr.cla.ddd.oo.pbt.EquatablePair;


public class SdtPairGenerator {

    public static EquatablePair generate() {
        return new EquatablePair(
            SdtGenerator.generateValue(),
            SdtGenerator.generateValue()
        );
    }

}

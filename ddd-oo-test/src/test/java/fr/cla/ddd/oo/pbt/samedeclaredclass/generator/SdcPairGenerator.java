package fr.cla.ddd.oo.pbt.samedeclaredclass.generator;

import fr.cla.ddd.oo.pbt.EquatablePair;

//@formatter:off
public class SdcPairGenerator {

    public static EquatablePair generate() {
        return new EquatablePair(
            SdcGenerator.generateValue(),
            SdcGenerator.generateValue()
        );
    }

}
//@formatter:on
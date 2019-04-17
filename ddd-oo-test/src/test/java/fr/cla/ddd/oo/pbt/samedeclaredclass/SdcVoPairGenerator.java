package fr.cla.ddd.oo.pbt.samedeclaredclass;

import fr.cla.ddd.oo.pbt.EquatablePair;

//@formatter:off
public class SdcVoPairGenerator {

    public static EquatablePair generate() {
        return new EquatablePair(
            SdcVoGenerator.generateValue(),
            SdcVoGenerator.generateValue()
        );
    }

}
//@formatter:on
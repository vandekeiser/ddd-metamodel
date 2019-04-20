package fr.cla.ddd.oo.pbt.samedeclaredclass.generator;

import fr.cla.ddd.oo.pbt.EquatableTriplet;

//@formatter:off
public class SdcTripletGenerator {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            SdcGenerator.generateValue(),
            SdcGenerator.generateValue(),
            SdcGenerator.generateValue()
        );
    }

}
//@formatter:on
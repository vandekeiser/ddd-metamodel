package fr.cla.ddd.oo.pbt.samedeclaredclass.generators;

import fr.cla.ddd.oo.pbt.EquatableTriplet;


public class SdcTripletGenerator {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            SdcGenerator.generateValue(),
            SdcGenerator.generateValue(),
            SdcGenerator.generateValue()
        );
    }

}

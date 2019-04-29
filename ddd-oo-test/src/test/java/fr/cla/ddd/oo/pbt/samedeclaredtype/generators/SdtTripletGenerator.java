package fr.cla.ddd.oo.pbt.samedeclaredtype.generators;

import fr.cla.ddd.oo.pbt.EquatableTriplet;


public class SdtTripletGenerator {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            SdtGenerator.generateValue(),
            SdtGenerator.generateValue(),
            SdtGenerator.generateValue()
        );
    }

}

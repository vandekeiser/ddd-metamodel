package fr.cla.ddd.oo.pbt.samedeclaredclass;

import fr.cla.ddd.oo.pbt.EquatableTriplet;

//@formatter:off
public class SdcVoTripletGenerator {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            SdcVoGenerator.generateValue(),
            SdcVoGenerator.generateValue(),
            SdcVoGenerator.generateValue()
        );
    }

}
//@formatter:on
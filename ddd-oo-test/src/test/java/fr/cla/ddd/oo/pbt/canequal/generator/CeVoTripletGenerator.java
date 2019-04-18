package fr.cla.ddd.oo.pbt.canequal.generator;

import fr.cla.ddd.oo.pbt.EquatableTriplet;

//@formatter:off
public class CeVoTripletGenerator {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            CeVoGenerator.generateValue(),
            CeVoGenerator.generateValue(),
            CeVoGenerator.generateValue()
        );
    }

}
//@formatter:on
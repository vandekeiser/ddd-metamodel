package fr.cla.ddd.oo.pbt.isinstance.generator;

import fr.cla.ddd.oo.pbt.EquatableTriplet;

//@formatter:off
public class IiTripletGenerator {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            IiGenerator.generateValue(),
            IiGenerator.generateValue(),
            IiGenerator.generateValue()
        );
    }

}
//@formatter:on
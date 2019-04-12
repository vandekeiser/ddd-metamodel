package fr.cla.ddd.oo.pbt.isinstance;

import fr.cla.ddd.oo.pbt.EquatableTriplet;

//@formatter:off
public class IiVoTripletGenerator {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            IiVoGenerator.generateValue(),
            IiVoGenerator.generateValue(),
            IiVoGenerator.generateValue()
        );
    }

}
//@formatter:on
package fr.cla.ddd.oo.pbt.sameconcreteclass;

import fr.cla.ddd.oo.pbt.EquatableTriplet;

//@formatter:off
public class SccVoTripletGenerator {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            SccVoGenerator.generateValue(),
            SccVoGenerator.generateValue(),
            SccVoGenerator.generateValue()
        );
    }

}
//@formatter:on
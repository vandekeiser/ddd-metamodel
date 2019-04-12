package fr.cla.ddd.oo.pbt.sameconcreteclass;

import fr.cla.ddd.oo.pbt.EquatableTriplet;

//@formatter:off
public class SccVoTripletGeneratorX {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            SccVoGeneratorX.generateValue(),
            SccVoGeneratorX.generateValue(),
            SccVoGeneratorX.generateValue()
        );
    }

}
//@formatter:on
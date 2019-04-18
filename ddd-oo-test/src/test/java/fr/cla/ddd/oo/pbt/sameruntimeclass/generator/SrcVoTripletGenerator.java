package fr.cla.ddd.oo.pbt.sameruntimeclass.generator;

import fr.cla.ddd.oo.pbt.EquatableTriplet;

//@formatter:off
public class SrcVoTripletGenerator {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            SrcVoGenerator.generateValue(),
            SrcVoGenerator.generateValue(),
            SrcVoGenerator.generateValue()
        );
    }

}
//@formatter:on
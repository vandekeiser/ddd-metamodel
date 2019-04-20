package fr.cla.ddd.oo.pbt.canequal.generators;

import fr.cla.ddd.oo.pbt.EquatableTriplet;

//@formatter:off
public class CeTripletGenerator {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            CeGenerator.generateValue(),
            CeGenerator.generateValue(),
            CeGenerator.generateValue()
        );
    }

}
//@formatter:on
package fr.cla.ddd.oo.pbt.canequal.generators;

import fr.cla.ddd.oo.pbt.EquatableTriplet;


public class CeTripletGenerator {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            CeGenerator.generateValue(),
            CeGenerator.generateValue(),
            CeGenerator.generateValue()
        );
    }

}

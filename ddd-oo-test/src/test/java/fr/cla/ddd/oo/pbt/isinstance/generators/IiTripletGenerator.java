package fr.cla.ddd.oo.pbt.isinstance.generators;

import fr.cla.ddd.oo.pbt.EquatableTriplet;


public class IiTripletGenerator {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            IiGenerator.generateEquatable(),
            IiGenerator.generateEquatable(),
            IiGenerator.generateEquatable()
        );
    }

}

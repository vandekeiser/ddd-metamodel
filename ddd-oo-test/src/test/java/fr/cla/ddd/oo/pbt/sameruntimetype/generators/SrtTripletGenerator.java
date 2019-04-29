package fr.cla.ddd.oo.pbt.sameruntimetype.generators;

import fr.cla.ddd.oo.pbt.EquatableTriplet;


public class SrtTripletGenerator {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            SrtGenerator.generateEquatable(),
            SrtGenerator.generateEquatable(),
            SrtGenerator.generateEquatable()
        );
    }

}

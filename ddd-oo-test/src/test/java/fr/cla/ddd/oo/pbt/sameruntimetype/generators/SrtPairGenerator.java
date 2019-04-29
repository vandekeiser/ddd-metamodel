package fr.cla.ddd.oo.pbt.sameruntimetype.generators;

import fr.cla.ddd.oo.pbt.EquatablePair;


public class SrtPairGenerator {

    public static EquatablePair generate() {
        return new EquatablePair(
            SrtGenerator.generateEquatable(),
            SrtGenerator.generateEquatable()
        );
    }

}

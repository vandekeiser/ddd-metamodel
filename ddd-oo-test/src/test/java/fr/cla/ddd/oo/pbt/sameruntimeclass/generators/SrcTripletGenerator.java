package fr.cla.ddd.oo.pbt.sameruntimeclass.generators;

import fr.cla.ddd.oo.pbt.EquatableTriplet;

//@formatter:off
public class SrcTripletGenerator {

    public static EquatableTriplet generate() {
        return new EquatableTriplet(
            SrcGenerator.generateEquatable(),
            SrcGenerator.generateEquatable(),
            SrcGenerator.generateEquatable()
        );
    }

}
//@formatter:on
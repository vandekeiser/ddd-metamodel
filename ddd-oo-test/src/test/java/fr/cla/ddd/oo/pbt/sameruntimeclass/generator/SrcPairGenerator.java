package fr.cla.ddd.oo.pbt.sameruntimeclass.generator;

import fr.cla.ddd.oo.pbt.EquatablePair;

//@formatter:off
public class SrcPairGenerator {

    public static EquatablePair generate() {
        return new EquatablePair(
            SrcGenerator.generateEquatable(),
            SrcGenerator.generateEquatable()
        );
    }

}
//@formatter:on
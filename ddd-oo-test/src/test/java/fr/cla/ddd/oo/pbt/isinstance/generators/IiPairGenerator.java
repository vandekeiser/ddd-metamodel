package fr.cla.ddd.oo.pbt.isinstance.generators;

import fr.cla.ddd.oo.pbt.EquatablePair;

//@formatter:off
public class IiPairGenerator {

    public static EquatablePair generate() {
        return new EquatablePair(
            IiGenerator.generateEquatable(),
            IiGenerator.generateEquatable()
        );
    }

}
//@formatter:on
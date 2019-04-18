package fr.cla.ddd.oo.pbt.isinstance.generator;

import fr.cla.ddd.oo.pbt.EquatablePair;

//@formatter:off
public class IiVoPairGenerator {

    public static EquatablePair generate() {
        return new EquatablePair(
            IiVoGenerator.generateValue(),
            IiVoGenerator.generateValue()
        );
    }

}
//@formatter:on
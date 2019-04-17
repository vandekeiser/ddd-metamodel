package fr.cla.ddd.oo.pbt.sameruntimeclass;

import fr.cla.ddd.oo.pbt.EquatablePair;

//@formatter:off
public class SrcVoPairGenerator {

    public static EquatablePair generate() {
        return new EquatablePair(
            SrcVoGenerator.generateValue(),
            SrcVoGenerator.generateValue()
        );
    }

}
//@formatter:on
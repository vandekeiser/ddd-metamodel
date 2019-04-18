package fr.cla.ddd.oo.pbt.sameruntimeclass.generator;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.sameruntimeclass.*;
import fr.cla.ddd.oo.pbt.EquatableSingleton;

import java.util.concurrent.ThreadLocalRandom;

//@formatter:off
public class SrcVoGenerator {

    public static EquatableSingleton generate() {
        return new EquatableSingleton(generateValue());
    }

    static Equatable<?> generateValue() {
        switch (ThreadLocalRandom.current().nextInt(6)) {
            case 0: return SrcVO1.random();
            case 1: return SrcVO2.random();
            case 2: return SrcVO1A.random();
            case 3: return SrcVO1B.random();
            case 4: return SrcVO2A.random();
            case 5: return SrcVO2B.random();
            default: throw new AssertionError();
        }
    }

}
//@formatter:on
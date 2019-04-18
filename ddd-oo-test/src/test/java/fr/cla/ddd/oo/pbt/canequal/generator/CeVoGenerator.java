package fr.cla.ddd.oo.pbt.canequal.generator;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.canequal.*;
import fr.cla.ddd.oo.pbt.EquatableSingleton;

import java.util.concurrent.ThreadLocalRandom;

//@formatter:off
public class CeVoGenerator {

    public static EquatableSingleton generate() {
        return new EquatableSingleton(generateValue());
    }

    static Equatable<?> generateValue() {
        switch (ThreadLocalRandom.current().nextInt(6)) {
            case 0: return CeVO1.random();
            case 1: return CeVO2.random();
            case 2: return CeVO1A.random();
            case 3: return CeVO1B.random();
            case 4: return CeVO2A.random();
            case 5: return CeVO2B.random();
            default: throw new AssertionError();
        }
    }

}
//@formatter:on
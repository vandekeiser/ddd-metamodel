package fr.cla.ddd.oo.pbt.samedeclaredclass.generator;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.samedeclaredclass.*;
import fr.cla.ddd.oo.pbt.EquatableSingleton;

import java.util.concurrent.ThreadLocalRandom;

//@formatter:off
public class SdcVoGenerator {

    public static EquatableSingleton generate() {
        return new EquatableSingleton(generateValue());
    }

    static Equatable<?> generateValue() {
        switch (ThreadLocalRandom.current().nextInt(6)) {
            case 0: return SdcVO1.random();
            case 1: return SdcVO2.random();
            case 2: return SdcVO1A.random();
            case 3: return SdcVO1B.random();
            case 4: return SdcVO2A.random();
            case 5: return SdcVO2B.random();
            default: throw new AssertionError();
        }
    }

}
//@formatter:on
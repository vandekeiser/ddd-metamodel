package fr.cla.ddd.oo.pbt.isinstance.generator;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.isinstance.*;
import fr.cla.ddd.oo.pbt.EquatableSingleton;

import java.util.concurrent.ThreadLocalRandom;

//@formatter:off
public class IiVoGenerator {

    public static EquatableSingleton generate() {
        return new EquatableSingleton(generateValue());
    }

    static Equatable<?> generateValue() {
        switch (ThreadLocalRandom.current().nextInt(6)) {
            case 0: return IiVO1.random();
            case 1: return IiVO2.random();
            case 2: return IiVO1A.random();
            case 3: return IiVO1B.random();
            case 4: return IiVO2A.random();
            case 5: return IiVO2B.random();
            default: throw new AssertionError();
        }
    }

}
//@formatter:on
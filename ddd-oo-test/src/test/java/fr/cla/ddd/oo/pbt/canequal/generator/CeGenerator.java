package fr.cla.ddd.oo.pbt.canequal.generator;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.Value;
import fr.cla.ddd.oo.exampleequatables.canequal.*;
import fr.cla.ddd.oo.pbt.EquatableSingleton;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

//@formatter:off
public class CeGenerator {

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

    static Supplier<Equatable<?>> generateDifferentButEqualEquatables() {
        int type = ThreadLocalRandom.current().nextInt(6);
        int subtype = ThreadLocalRandom.current().nextInt(3);
        Value x = Value.random();
        Value y = Value.random();

        return generateDifferentButEqualEquatables(type, subtype, x, y);
    }

    private static Supplier<Equatable<?>> generateDifferentButEqualEquatables(int type, int subtype, Value x, Value y) {
        switch (type) {
            case 0: return () -> randomCeVO1(subtype, x, y);
            case 1: return () -> randomCeVO2(subtype, x, y);
            case 2: return () -> new CeVO1A(x);
            case 3: return () -> new CeVO1B(x,y);
            case 4: return () -> new CeVO2A(x,y);
            case 5: return () -> new CeVO2B(x,y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomCeVO1(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new CeVO1(x);
            case 1: return new CeVO1A(x);
            case 2: return new CeVO1B(x, y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomCeVO2(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new CeVO2(x);
            case 1: return new CeVO2A(x, y);
            case 2: return new CeVO2B(x, y);
            default: throw new AssertionError();
        }
    }

}
//@formatter:on
package fr.cla.ddd.oo.pbt.canequal.generators;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.canequal.exampleequatables.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

//@formatter:off
public class CeGenerator {

    public static EquatableSingleton generate() {
        return new EquatableSingleton(generateValue());
    }

    static Equatable<?> generateValue() {
        switch (ThreadLocalRandom.current().nextInt(6)) {
            case 0: return Ce1.random();
            case 1: return Ce2.random();
            case 2: return Ce1A.random();
            case 3: return Ce1B.random();
            case 4: return Ce2A.random();
            case 5: return Ce2B.random();
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
            case 2: return () -> new Ce1A(x);
            case 3: return () -> new Ce1B(x,y);
            case 4: return () -> new Ce2A(x,y);
            case 5: return () -> new Ce2B(x,y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomCeVO1(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new Ce1(x);
            case 1: return new Ce1A(x);
            case 2: return new Ce1B(x, y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomCeVO2(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new Ce2(x);
            case 1: return new Ce2A(x, y);
            case 2: return new Ce2B(x, y);
            default: throw new AssertionError();
        }
    }

}
//@formatter:on
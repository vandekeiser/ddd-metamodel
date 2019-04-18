package fr.cla.ddd.oo.pbt.isinstance.generator;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.Value;
import fr.cla.ddd.oo.exampleequatables.isinstance.*;
import fr.cla.ddd.oo.pbt.EquatableSingleton;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

//@formatter:off
public class IiGenerator {

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

    static Supplier<Equatable<?>> generateDifferentButEqualEquatables() {
        int type = ThreadLocalRandom.current().nextInt(6);
        Value x = Value.random();
        Value y = Value.random();

        return generateDifferentButEqualEquatables(type, x, y);
    }

    private static Supplier<Equatable<?>> generateDifferentButEqualEquatables(int type, Value x, Value y) {
        switch (type) {
            case 0: return () -> new IiVO1(x);
            case 1: return () -> new IiVO1(x);
            case 2: return () -> new IiVO1A(x,y);
            case 3: return () -> new IiVO1B(x,y);
            case 4: return () -> new IiVO2A(x,y);
            case 5: return () -> new IiVO2B(x,y);
            default: throw new AssertionError();
        }
    }
}
//@formatter:on
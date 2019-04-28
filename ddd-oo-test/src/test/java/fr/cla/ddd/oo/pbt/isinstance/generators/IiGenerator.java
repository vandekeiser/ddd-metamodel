package fr.cla.ddd.oo.pbt.isinstance.generators;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.isinstance.exampleequatables.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

//@formatter:off
public class IiGenerator {

    public static EquatableSingleton generate() {
        return new EquatableSingleton(generateEquatable());
    }

    static Equatable<?> generateEquatable() {
        switch (ThreadLocalRandom.current().nextInt(6)) {
            case 0: return Ii1.random();
            case 1: return Ii2.random();
            case 2: return Ii1A.random();
            case 3: return Ii1B.random();
            case 4: return Ii2A.random();
            case 5: return Ii2B.random();
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
            case 0: return () -> randomIiVO1(subtype, x, y);
            case 1: return () -> randomIiVO2(subtype, x, y);
            case 2: return () -> new Ii1A(x,y);
            case 3: return () -> new Ii1B(x,y);
            case 4: return () -> new Ii2A(x,y);
            case 5: return () -> new Ii2B(x,y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomIiVO1(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new Ii1(x);
            case 1: return new Ii1A(x, y);
            case 2: return new Ii1B(x, y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomIiVO2(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new Ii2(x);
            case 1: return new Ii2A(x, y);
            case 2: return new Ii2B(x, y);
            default: throw new AssertionError();
        }
    }
}
//@formatter:on
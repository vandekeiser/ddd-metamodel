package fr.cla.ddd.oo.pbt.samedeclaredtype.generators;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.Value;
import fr.cla.ddd.oo.pbt.samedeclaredtype.exampleequatables.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;


public class SdtGenerator {

    public static EquatableSingleton generate() {
        return new EquatableSingleton(generateValue());
    }

    static Equatable<?> generateValue() {
        switch (ThreadLocalRandom.current().nextInt(6)) {
            case 0: return Sdt1.random();
            case 1: return Sdt2.random();
            case 2: return Sdt1A.random();
            case 3: return Sdt1B.random();
            case 4: return Sdt2A.random();
            case 5: return Sdt2B.random();
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
            case 0: return () -> randomVO1(subtype, x, y);
            case 1: return () -> randomVO2(subtype, x, y);
            case 2: return () -> new Sdt1A(x,y);
            case 3: return () -> new Sdt1B(x,y);
            case 4: return () -> new Sdt2A(x,y);
            case 5: return () -> new Sdt2B(x,y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomVO1(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new Sdt1(x);
            case 1: return new Sdt1A(x, y);
            case 2: return new Sdt1B(x, y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomVO2(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new Sdt2(x);
            case 1: return new Sdt2A(x, y);
            case 2: return new Sdt2B(x, y);
            default: throw new AssertionError();
        }
    }

}

package fr.cla.ddd.oo.pbt.samedeclaredclass.generator;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.Value;
import fr.cla.ddd.oo.exampleequatables.samedeclaredclass.*;
import fr.cla.ddd.oo.pbt.EquatableSingleton;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

//@formatter:off
public class SdcGenerator {

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

    static Supplier<Equatable<?>> generateDifferentButEqualEquatables() {
        int type = ThreadLocalRandom.current().nextInt(6);
        int subtype = ThreadLocalRandom.current().nextInt(3);
        Value x = Value.random();
        Value y = Value.random();

        return generateDifferentButEqualEquatables(type, subtype, x, y);
    }

    private static Supplier<Equatable<?>> generateDifferentButEqualEquatables(int type, int subtype, Value x, Value y) {
        switch (type) {
            case 0: return () -> randomSdcVO1(subtype, x, y);
            case 1: return () -> randomSdcVO2(subtype, x, y);
            case 2: return () -> new SdcVO1A(x,y);
            case 3: return () -> new SdcVO1B(x,y);
            case 4: return () -> new SdcVO2A(x,y);
            case 5: return () -> new SdcVO2B(x,y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomSdcVO1(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new SdcVO1(x);
            case 1: return new SdcVO1A(x, y);
            case 2: return new SdcVO1B(x, y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomSdcVO2(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new SdcVO2(x);
            case 1: return new SdcVO2A(x, y);
            case 2: return new SdcVO2B(x, y);
            default: throw new AssertionError();
        }
    }

}
//@formatter:on
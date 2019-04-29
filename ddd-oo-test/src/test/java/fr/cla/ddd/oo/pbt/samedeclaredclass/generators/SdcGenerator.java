package fr.cla.ddd.oo.pbt.samedeclaredclass.generators;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.samedeclaredclass.exampleequatables.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;


public class SdcGenerator {

    public static EquatableSingleton generate() {
        return new EquatableSingleton(generateValue());
    }

    static Equatable<?> generateValue() {
        switch (ThreadLocalRandom.current().nextInt(6)) {
            case 0: return Sdc1.random();
            case 1: return Sdc2.random();
            case 2: return Sdc1A.random();
            case 3: return Sdc1B.random();
            case 4: return Sdc2A.random();
            case 5: return Sdc2B.random();
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
            case 2: return () -> new Sdc1A(x,y);
            case 3: return () -> new Sdc1B(x,y);
            case 4: return () -> new Sdc2A(x,y);
            case 5: return () -> new Sdc2B(x,y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomSdcVO1(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new Sdc1(x);
            case 1: return new Sdc1A(x, y);
            case 2: return new Sdc1B(x, y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomSdcVO2(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new Sdc2(x);
            case 1: return new Sdc2A(x, y);
            case 2: return new Sdc2B(x, y);
            default: throw new AssertionError();
        }
    }

}

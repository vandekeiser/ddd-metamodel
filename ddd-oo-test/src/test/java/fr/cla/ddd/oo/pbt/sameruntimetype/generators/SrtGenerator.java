package fr.cla.ddd.oo.pbt.sameruntimetype.generators;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.Value;
import fr.cla.ddd.oo.pbt.sameruntimetype.exampleequatables.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;


public class SrtGenerator {

    public static EquatableSingleton generate() {
        return new EquatableSingleton(generateEquatable());
    }

    static Equatable<?> generateEquatable() {
        switch (ThreadLocalRandom.current().nextInt(6)) {
            case 0: return Srt1.random();
            case 1: return Srt2.random();
            case 2: return Srt1A.random();
            case 3: return Srt1B.random();
            case 4: return Srt2A.random();
            case 5: return Srt2B.random();
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
            case 2: return () -> new Srt1A(x,y);
            case 3: return () -> new Srt1B(x,y);
            case 4: return () -> new Srt2A(x,y);
            case 5: return () -> new Srt2B(x,y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomVO1(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new Srt1(x);
            case 1: return new Srt1A(x, y);
            case 2: return new Srt1B(x, y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomVO2(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new Srt2(x);
            case 1: return new Srt2A(x, y);
            case 2: return new Srt2B(x, y);
            default: throw new AssertionError();
        }
    }

}

package fr.cla.ddd.oo.pbt.sameruntimeclass.generator;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.Value;
import fr.cla.ddd.oo.exampleequatables.isinstance.IiVO1;
import fr.cla.ddd.oo.exampleequatables.isinstance.IiVO1A;
import fr.cla.ddd.oo.exampleequatables.isinstance.IiVO1B;
import fr.cla.ddd.oo.exampleequatables.sameruntimeclass.*;
import fr.cla.ddd.oo.pbt.EquatableSingleton;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

//@formatter:off
public class SrcGenerator {

    public static EquatableSingleton generate() {
        return new EquatableSingleton(generateEquatable());
    }

    static Equatable<?> generateEquatable() {
        switch (ThreadLocalRandom.current().nextInt(6)) {
            case 0: return SrcVO1.random();
            case 1: return SrcVO2.random();
            case 2: return SrcVO1A.random();
            case 3: return SrcVO1B.random();
            case 4: return SrcVO2A.random();
            case 5: return SrcVO2B.random();
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
            case 0: return () -> randomSrcVO1(subtype, x, y);
            case 1: return () -> randomSrcVO2(subtype, x, y);
            case 2: return () -> new SrcVO1A(x,y);
            case 3: return () -> new SrcVO1B(x,y);
            case 4: return () -> new SrcVO2A(x,y);
            case 5: return () -> new SrcVO2B(x,y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomSrcVO1(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new SrcVO1(x);
            case 1: return new SrcVO1A(x, y);
            case 2: return new SrcVO1B(x, y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomSrcVO2(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new SrcVO2(x);
            case 1: return new SrcVO2A(x, y);
            case 2: return new SrcVO2B(x, y);
            default: throw new AssertionError();
        }
    }

}
//@formatter:on
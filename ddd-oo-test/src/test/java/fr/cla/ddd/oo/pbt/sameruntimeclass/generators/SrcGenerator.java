package fr.cla.ddd.oo.pbt.sameruntimeclass.generators;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.Value;
import fr.cla.ddd.oo.pbt.sameruntimeclass.exampleequatables.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;


public class SrcGenerator {

    public static EquatableSingleton generate() {
        return new EquatableSingleton(generateEquatable());
    }

    static Equatable<?> generateEquatable() {
        switch (ThreadLocalRandom.current().nextInt(6)) {
            case 0: return Src1.random();
            case 1: return Src2.random();
            case 2: return Src1A.random();
            case 3: return Src1B.random();
            case 4: return Src2A.random();
            case 5: return Src2B.random();
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
            case 2: return () -> new Src1A(x,y);
            case 3: return () -> new Src1B(x,y);
            case 4: return () -> new Src2A(x,y);
            case 5: return () -> new Src2B(x,y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomSrcVO1(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new Src1(x);
            case 1: return new Src1A(x, y);
            case 2: return new Src1B(x, y);
            default: throw new AssertionError();
        }
    }

    private static Equatable<?> randomSrcVO2(int subtype, Value x, Value y) {
        switch (subtype) {
            case 0: return new Src2(x);
            case 1: return new Src2A(x, y);
            case 2: return new Src2B(x, y);
            default: throw new AssertionError();
        }
    }

}

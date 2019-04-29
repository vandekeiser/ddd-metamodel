package fr.cla.ddd.oo.pbt.sameruntimeclass.generators;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.EqualPair;

import java.util.function.Supplier;


public class SrcEqualPairGenerator {

    public static EqualPair generate() {
        Supplier<Equatable<?>> differentButEqualEquatables = SrcGenerator.generateDifferentButEqualEquatables();

        return new EqualPair(
            differentButEqualEquatables.get(),
            differentButEqualEquatables.get()
        );
    }

}

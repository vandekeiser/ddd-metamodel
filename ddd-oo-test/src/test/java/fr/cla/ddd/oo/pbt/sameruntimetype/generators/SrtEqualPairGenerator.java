package fr.cla.ddd.oo.pbt.sameruntimetype.generators;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.EqualPair;

import java.util.function.Supplier;


public class SrtEqualPairGenerator {

    public static EqualPair generate() {
        Supplier<Equatable<?>> differentButEqualEquatables = SrtGenerator.generateDifferentButEqualEquatables();

        return new EqualPair(
            differentButEqualEquatables.get(),
            differentButEqualEquatables.get()
        );
    }

}

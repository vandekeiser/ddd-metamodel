package fr.cla.ddd.oo.pbt.canequal.generators;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.EqualPair;

import java.util.function.Supplier;

//@formatter:off
public class CeEqualPairGenerator {

    public static EqualPair generate() {
        Supplier<Equatable<?>> differentButEqualEquatables = CeGenerator.generateDifferentButEqualEquatables();

        return new EqualPair(
            differentButEqualEquatables.get(),
            differentButEqualEquatables.get()
        );
    }

}
//@formatter:on
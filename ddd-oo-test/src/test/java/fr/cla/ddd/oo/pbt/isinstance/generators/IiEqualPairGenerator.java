package fr.cla.ddd.oo.pbt.isinstance.generators;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.EqualPair;

import java.util.function.Supplier;

//@formatter:off
public class IiEqualPairGenerator {

    public static EqualPair generate() {
        Supplier<Equatable<?>> differentButEqualEquatables = IiGenerator.generateDifferentButEqualEquatables();

        return new EqualPair(
            differentButEqualEquatables.get(),
            differentButEqualEquatables.get()
        );
    }

}
//@formatter:on
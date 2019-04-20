package fr.cla.ddd.oo.pbt.samedeclaredclass.generators;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.EqualPair;

import java.util.function.Supplier;

//@formatter:off
public class SdcEqualPairGenerator {

    public static EqualPair generate() {
        Supplier<Equatable<?>> differentButEqualEquatables = SdcGenerator.generateDifferentButEqualEquatables();

        return new EqualPair(
            differentButEqualEquatables.get(),
            differentButEqualEquatables.get()
        );
    }

}
//@formatter:on
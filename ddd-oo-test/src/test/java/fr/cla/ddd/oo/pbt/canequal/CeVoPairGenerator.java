package fr.cla.ddd.oo.pbt.canequal;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.pbt.EquatablePair;

//@formatter:off
public class CeVoPairGenerator extends Generator<EquatablePair> {

    public CeVoPairGenerator() {
        super(EquatablePair.class);
    }

    @Override
    public EquatablePair generate(SourceOfRandomness rand, GenerationStatus status) {
        return new EquatablePair(
            CeVoGenerator.generate(rand),
            CeVoGenerator.generate(rand)
        );
    }

}
//@formatter:on
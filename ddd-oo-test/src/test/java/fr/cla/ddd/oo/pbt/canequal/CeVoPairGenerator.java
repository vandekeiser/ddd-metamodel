package fr.cla.ddd.oo.pbt.canequal;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.pbt.VoPair;

//@formatter:off
public class CeVoPairGenerator extends Generator<VoPair> {

    public CeVoPairGenerator() {
        super(VoPair.class);
    }

    @Override
    public VoPair generate(SourceOfRandomness rand, GenerationStatus status) {
        return new VoPair(
            CeVoGenerator.generate(rand),
            CeVoGenerator.generate(rand)
        );
    }

}
//@formatter:on
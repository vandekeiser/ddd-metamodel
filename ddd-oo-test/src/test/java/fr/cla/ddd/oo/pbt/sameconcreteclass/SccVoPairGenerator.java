package fr.cla.ddd.oo.pbt.sameconcreteclass;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.pbt.VoPair;

//@formatter:off
public class SccVoPairGenerator extends Generator<VoPair> {

    public SccVoPairGenerator() {
        super(VoPair.class);
    }

    @Override
    public VoPair generate(SourceOfRandomness rand, GenerationStatus status) {
        return new VoPair(
            SccVoGenerator.generate(rand),
            SccVoGenerator.generate(rand)
        );
    }

}
//@formatter:on
package fr.cla.ddd.oo.pbt.sameconcreteclass;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.pbt.EquatablePair;

//@formatter:off
public class SccVoPairGenerator extends Generator<EquatablePair> {

    public SccVoPairGenerator() {
        super(EquatablePair.class);
    }

    @Override
    public EquatablePair generate(SourceOfRandomness rand, GenerationStatus status) {
        return new EquatablePair(
            SccVoGenerator.generate(rand),
            SccVoGenerator.generate(rand)
        );
    }

}
//@formatter:on
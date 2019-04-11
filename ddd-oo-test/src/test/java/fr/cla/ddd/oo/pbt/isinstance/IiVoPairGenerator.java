package fr.cla.ddd.oo.pbt.isinstance;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.pbt.EquatablePair;

//@formatter:off
public class IiVoPairGenerator extends Generator<EquatablePair> {

    public IiVoPairGenerator() {
        super(EquatablePair.class);
    }

    @Override
    public EquatablePair generate(SourceOfRandomness rand, GenerationStatus status) {
        return new EquatablePair(
            IiVoGenerator.generate(rand),
            IiVoGenerator.generate(rand)
        );
    }

}
//@formatter:on
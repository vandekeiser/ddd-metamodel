package fr.cla.ddd.metamodel.pbt.isinstance;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.pbt.VoPair;

//@formatter:off
public class IiVoPairGenerator extends Generator<VoPair> {

    public IiVoPairGenerator() {
        super(VoPair.class);
    }

    @Override
    public VoPair generate(SourceOfRandomness rand, GenerationStatus status) {
        return new VoPair(
            IiVoGenerator.generate(rand),
            IiVoGenerator.generate(rand)
        );
    }

}
//@formatter:on
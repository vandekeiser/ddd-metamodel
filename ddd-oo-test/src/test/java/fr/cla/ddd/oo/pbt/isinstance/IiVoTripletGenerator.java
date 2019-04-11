package fr.cla.ddd.oo.pbt.isinstance;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.pbt.EquatableTriplet;

//@formatter:off
public class IiVoTripletGenerator extends Generator<EquatableTriplet> {

    public IiVoTripletGenerator() {
        super(EquatableTriplet.class);
    }

    @Override
    public EquatableTriplet generate(SourceOfRandomness rand, GenerationStatus status) {
        return new EquatableTriplet(
            IiVoGenerator.generate(rand),
            IiVoGenerator.generate(rand),
            IiVoGenerator.generate(rand)
        );
    }

}
//@formatter:on
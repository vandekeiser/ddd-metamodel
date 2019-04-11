package fr.cla.ddd.oo.pbt.sameconcreteclass;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.pbt.EquatableTriplet;

//@formatter:off
public class SccVoTripletGenerator extends Generator<EquatableTriplet> {

    public SccVoTripletGenerator() {
        super(EquatableTriplet.class);
    }

    @Override
    public EquatableTriplet generate(SourceOfRandomness rand, GenerationStatus status) {
        return new EquatableTriplet(
            SccVoGenerator.generate(rand),
            SccVoGenerator.generate(rand),
            SccVoGenerator.generate(rand)
        );
    }

}
//@formatter:on
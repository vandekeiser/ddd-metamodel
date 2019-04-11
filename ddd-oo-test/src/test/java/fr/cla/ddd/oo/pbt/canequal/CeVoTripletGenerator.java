package fr.cla.ddd.oo.pbt.canequal;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.pbt.EquatableTriplet;

//@formatter:off
public class CeVoTripletGenerator extends Generator<EquatableTriplet> {

    public CeVoTripletGenerator() {
        super(EquatableTriplet.class);
    }

    @Override
    public EquatableTriplet generate(SourceOfRandomness rand, GenerationStatus status) {
        return new EquatableTriplet(
            CeVoGenerator.generate(rand),
            CeVoGenerator.generate(rand),
            CeVoGenerator.generate(rand)
        );
    }

}
//@formatter:on
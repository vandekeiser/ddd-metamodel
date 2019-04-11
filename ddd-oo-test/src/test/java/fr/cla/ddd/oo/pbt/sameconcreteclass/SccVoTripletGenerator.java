package fr.cla.ddd.oo.pbt.sameconcreteclass;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.pbt.VoTriplet;

//@formatter:off
public class SccVoTripletGenerator extends Generator<VoTriplet> {

    public SccVoTripletGenerator() {
        super(VoTriplet.class);
    }

    @Override
    public VoTriplet generate(SourceOfRandomness rand, GenerationStatus status) {
        return new VoTriplet(
            SccVoGenerator.generate(rand),
            SccVoGenerator.generate(rand),
            SccVoGenerator.generate(rand)
        );
    }

}
//@formatter:on
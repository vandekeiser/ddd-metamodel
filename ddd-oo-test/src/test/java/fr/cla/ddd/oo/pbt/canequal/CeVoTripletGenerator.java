package fr.cla.ddd.oo.pbt.canequal;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.pbt.VoTriplet;

//@formatter:off
public class CeVoTripletGenerator extends Generator<VoTriplet> {

    public CeVoTripletGenerator() {
        super(VoTriplet.class);
    }

    @Override
    public VoTriplet generate(SourceOfRandomness rand, GenerationStatus status) {
        return new VoTriplet(
            CeVoGenerator.generate(rand),
            CeVoGenerator.generate(rand),
            CeVoGenerator.generate(rand)
        );
    }

}
//@formatter:on
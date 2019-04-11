package fr.cla.ddd.metamodel.pbt.isinstance;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.pbt.VoTriplet;

//@formatter:off
public class IiVoTripletGenerator extends Generator<VoTriplet> {

    public IiVoTripletGenerator() {
        super(VoTriplet.class);
    }

    @Override
    public VoTriplet generate(SourceOfRandomness rand, GenerationStatus status) {
        return new VoTriplet(
            IiVoGenerator.generate(rand),
            IiVoGenerator.generate(rand),
            IiVoGenerator.generate(rand)
        );
    }

}
//@formatter:on
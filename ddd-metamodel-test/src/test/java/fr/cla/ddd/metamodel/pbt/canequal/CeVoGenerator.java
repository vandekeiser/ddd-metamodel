package fr.cla.ddd.metamodel.pbt.canequal;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.examplevos.canequal.*;
import fr.cla.ddd.metamodel.pbt.VoSingleton;

//@formatter:off
public class CeVoGenerator extends Generator<VoSingleton> {

    public CeVoGenerator() {
        super(VoSingleton.class);
    }

    @Override
    public VoSingleton generate(SourceOfRandomness rand, GenerationStatus status) {
        return new VoSingleton(generate(rand));
    }

    static AbstractValueObject<?> generate(SourceOfRandomness rand) {
        switch (rand.nextInt(6)) {
            case 0: return CeVO1.random(rand);
            case 1: return CeVO2.random(rand);
            case 2: return CeVO1A.random(rand);
            case 3: return CeVO1B.random(rand);
            case 4: return CeVO2A.random(rand);
            case 5: return CeVO2B.random(rand);
            default: throw new AssertionError();
        }
    }

}
//@formatter:on
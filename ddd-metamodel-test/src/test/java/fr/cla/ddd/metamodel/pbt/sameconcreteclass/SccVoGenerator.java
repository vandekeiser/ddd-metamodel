package fr.cla.ddd.metamodel.pbt.sameconcreteclass;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.example.vos.sameconcreteclass.*;
import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.pbt.VoSingleton;

//@formatter:off
public class SccVoGenerator extends Generator<VoSingleton> {

    public SccVoGenerator() {
        super(VoSingleton.class);
    }

    @Override
    public VoSingleton generate(SourceOfRandomness rand, GenerationStatus status) {
        return new VoSingleton(generate(rand));
    }

    static AbstractValueObject<?> generate(SourceOfRandomness rand) {
        switch (rand.nextInt(6)) {
            case 0: return SccVO1.random(rand);
            case 1: return SccVO2.random(rand);
            case 2: return SccVO1A.random(rand);
            case 3: return SccVO1B.random(rand);
            case 4: return SccVO2A.random(rand);
            case 5: return SccVO2B.random(rand);
            default: throw new AssertionError();
        }
    }

}
//@formatter:on
package fr.cla.ddd.oo.pbt.isinstance;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.example.equatables.isinstance.*;
import fr.cla.ddd.oo.pbt.VoSingleton;

//@formatter:off
public class IiVoGenerator extends Generator<VoSingleton> {

    public IiVoGenerator() {
        super(VoSingleton.class);
    }

    @Override
    public VoSingleton generate(SourceOfRandomness rand, GenerationStatus status) {
        return new VoSingleton(generate(rand));
    }

    static Equatable<?> generate(SourceOfRandomness rand) {
        switch (rand.nextInt(6)) {
            case 0: return IiVO1.random(rand);
            case 1: return IiVO2.random(rand);
            case 2: return IiVO1A.random(rand);
            case 3: return IiVO1B.random(rand);
            case 4: return IiVO2A.random(rand);
            case 5: return IiVO2B.random(rand);
            default: throw new AssertionError();
        }
    }

}
//@formatter:on
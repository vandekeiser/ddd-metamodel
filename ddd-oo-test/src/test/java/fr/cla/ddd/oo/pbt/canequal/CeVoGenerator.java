package fr.cla.ddd.oo.pbt.canequal;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.example.equatables.canequal.*;
import fr.cla.ddd.oo.pbt.EquatableSingleton;

//@formatter:off
public class CeVoGenerator extends Generator<EquatableSingleton> {

    public CeVoGenerator() {
        super(EquatableSingleton.class);
    }

    @Override
    public EquatableSingleton generate(SourceOfRandomness rand, GenerationStatus status) {
        return new EquatableSingleton(generate(rand));
    }

    static Equatable<?> generate(SourceOfRandomness rand) {
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
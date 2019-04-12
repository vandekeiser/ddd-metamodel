package fr.cla.ddd.oo.example.equatables.sameconcreteclass;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.example.equatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class SccVO2B extends SccVO2 {

    private final Value y;

    public SccVO2B(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static SccVO2B random(SourceOfRandomness rand) {
        return new SccVO2B(
            Value.random(rand),
            Value.random(rand)
        );
    }

    public static SccVO2B random() {
        return new SccVO2B(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}
//@formatter:on
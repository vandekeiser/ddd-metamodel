package fr.cla.ddd.oo.example.equatables.sameconcreteclass;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.example.equatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class SccVO2A extends SccVO2 {

    private final Value y;

    public SccVO2A(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static SccVO2A random(SourceOfRandomness rand) {
        return new SccVO2A(
            Value.random(rand),
            Value.random(rand)
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}
//@formatter:on
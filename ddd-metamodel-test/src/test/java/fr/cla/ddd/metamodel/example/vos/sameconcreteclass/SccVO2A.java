package fr.cla.ddd.metamodel.example.vos.sameconcreteclass;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.example.vos.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
@DDD.ValueObject
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
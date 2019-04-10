package fr.cla.ddd.metamodel.examplevos.sameconcreteclass;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.examplevos.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public class SccVO2A extends SccVO2 {

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

    @Override
    protected boolean canEqual(AbstractValueObject<?> that) {
        return that instanceof SccVO2A;
    }

}
//@formatter:on
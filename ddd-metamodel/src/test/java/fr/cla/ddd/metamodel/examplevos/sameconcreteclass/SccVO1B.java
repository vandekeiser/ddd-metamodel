package fr.cla.ddd.metamodel.examplevos.sameconcreteclass;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.examplevos.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public class SccVO1B extends SccVO1 {

    private final Value y;

    public SccVO1B(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static SccVO1B random(SourceOfRandomness rand) {
        return new SccVO1B(
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
        return that instanceof SccVO1B;
    }

}
//@formatter:on
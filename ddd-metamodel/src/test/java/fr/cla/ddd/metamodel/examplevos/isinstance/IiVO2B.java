package fr.cla.ddd.metamodel.examplevos.isinstance;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.examplevos.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public class IiVO2B extends IiVO2 {

    private final Value y;

    public IiVO2B(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static IiVO2B random(SourceOfRandomness rand) {
        return new IiVO2B(
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
        return that instanceof IiVO2B;
    }

}
//@formatter:on
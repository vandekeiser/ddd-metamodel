package fr.cla.ddd.metamodel.examplevos.isinstance;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.examplevos.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public class IiVO1A extends IiVO1 {

    private final Value y;

    public IiVO1A(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static IiVO1A random(SourceOfRandomness rand) {
        return new IiVO1A(
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
        return that instanceof IiVO1A;
    }

}
//@formatter:on
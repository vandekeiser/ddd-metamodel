package fr.cla.ddd.metamodel.examplevos.canequal;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.examplevos.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public class CeVO1B extends CeVO1 {

    private final Value y;

    public CeVO1B(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static CeVO1B random(SourceOfRandomness rand) {
        return new CeVO1B(
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
        return that instanceof CeVO1B;
    }

}
//@formatter:on
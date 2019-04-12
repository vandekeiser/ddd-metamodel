package fr.cla.ddd.metamodel.example.vos.canequal;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.example.vos.Value;
import fr.cla.ddd.oo.Equatable;

import java.util.Arrays;
import java.util.List;

//@formatter:off
@DDD.ValueObject
public class CeVO2B extends CeVO2 {

    private final Value y;

    public CeVO2B(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static CeVO2B random(SourceOfRandomness rand) {
        return new CeVO2B(
            Value.random(rand),
            Value.random(rand)
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

    @Override
    protected boolean canEqual(Equatable<?> that) {
        return that instanceof CeVO2B;
    }

}
//@formatter:on
package fr.cla.ddd.metamodel.example.vos.canequal;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.example.vos.Value;
import fr.cla.ddd.oo.Equatable;

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
    protected boolean canEqual(Equatable<?> that) {
        return that instanceof CeVO1B;
    }

}
//@formatter:on
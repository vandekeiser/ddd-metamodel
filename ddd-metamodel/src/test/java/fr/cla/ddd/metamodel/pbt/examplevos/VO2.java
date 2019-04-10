package fr.cla.ddd.metamodel.pbt.examplevos;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.AbstractValueObject;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class VO2 extends AbstractValueObject<VO2> {

    protected final Value x;

    public VO2(Value x) {
        super(VO2.class);
        this.x = x;
    }

    public static VO2 random(SourceOfRandomness rand) {
        return new VO2(Value.random(rand));
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

    @Override
    protected boolean canEqual(AbstractValueObject<?> that) {
        return that instanceof VO2;
    }

}
//@formatter:on
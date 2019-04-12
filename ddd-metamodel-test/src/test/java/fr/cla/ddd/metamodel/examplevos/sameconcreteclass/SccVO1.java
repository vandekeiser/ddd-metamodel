package fr.cla.ddd.metamodel.examplevos.sameconcreteclass;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.examplevos.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
@DDD.ValueObject
public class SccVO1 extends AbstractValueObject<SccVO1> {

    protected final Value x;

    public SccVO1(Value x) {
        super(SccVO1.class, Equatability.SAME_CONCRETE_CLASS);
        this.x = x;
    }

    public static SccVO1 random(SourceOfRandomness rand) {
        return new SccVO1(Value.random(rand));
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}
//@formatter:on
package fr.cla.ddd.metamodel.examplevos.isinstance;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.examplevos.Value;
import fr.cla.ddd.metamodel.AbstractValueObject;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
@DDD.ValueObject
public class IiVO1 extends AbstractValueObject<IiVO1> {

    protected final Value x;

    public IiVO1(Value x) {
        super(IiVO1.class, Equatability.IS_INSTANCE);
        this.x = x;
    }

    public static IiVO1 random(SourceOfRandomness rand) {
        return new IiVO1(Value.random(rand));
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}
//@formatter:on
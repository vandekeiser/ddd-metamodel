package fr.cla.ddd.metamodel.examplevos.isinstance;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.examplevos.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class IiVO1 extends AbstractValueObject<IiVO1> {

    protected final Value x;

    public IiVO1(Value x) {
        super(IiVO1.class);
        this.x = x;
    }

    public static IiVO1 random(SourceOfRandomness rand) {
        return new IiVO1(Value.random(rand));
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

    @Override
    protected boolean canEqual(AbstractValueObject<?> that) {
        return that instanceof IiVO1;
    }

}
//@formatter:on
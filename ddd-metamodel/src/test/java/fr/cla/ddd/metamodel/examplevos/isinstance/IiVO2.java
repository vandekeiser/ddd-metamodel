package fr.cla.ddd.metamodel.examplevos.isinstance;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.examplevos.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class IiVO2 extends AbstractValueObject<IiVO2> {

    protected final Value x;

    public IiVO2(Value x) {
        super(IiVO2.class);
        this.x = x;
    }

    public static IiVO2 random(SourceOfRandomness rand) {
        return new IiVO2(Value.random(rand));
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}
//@formatter:on
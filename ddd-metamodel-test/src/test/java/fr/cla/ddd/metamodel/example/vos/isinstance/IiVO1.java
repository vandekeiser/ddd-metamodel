package fr.cla.ddd.metamodel.example.vos.isinstance;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.example.vos.Value;
import fr.cla.ddd.metamodel.AbstractValueObject;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
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
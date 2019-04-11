package fr.cla.ddd.metamodel.example.vos.sameconcreteclass;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.example.vos.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class SccVO2 extends AbstractValueObject<SccVO2> {

    protected final Value x;

    public SccVO2(Value x) {
        super(SccVO2.class, Equatability.SAME_CONCRETE_CLASS);
        this.x = x;
    }

    public static SccVO2 random(SourceOfRandomness rand) {
        return new SccVO2(Value.random(rand));
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}
//@formatter:on
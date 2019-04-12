package fr.cla.ddd.metamodel.example.vos.canequal;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.example.vos.Value;
import fr.cla.ddd.oo.Equatable;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
@DDD.ValueObject
public class CeVO1 extends AbstractValueObject<CeVO1> {

    protected final Value x;

    public CeVO1(Value x) {
        super(CeVO1.class, Equatability.CAN_EQUAL);
        this.x = x;
    }

    public static CeVO1 random(SourceOfRandomness rand) {
        return new CeVO1(Value.random(rand));
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

    @Override
    protected boolean canEqual(Equatable<?> that) {
        return that instanceof CeVO1;
    }

}
//@formatter:on
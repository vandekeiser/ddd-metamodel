package fr.cla.ddd.oo.example.equatables.sameconcreteclass;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.example.equatables.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class SccVO1 extends Equatable<SccVO1> {

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
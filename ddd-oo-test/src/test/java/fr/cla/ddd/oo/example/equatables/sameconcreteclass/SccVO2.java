package fr.cla.ddd.oo.example.equatables.sameconcreteclass;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.example.equatables.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class SccVO2 extends Equatable<SccVO2> {

    protected final Value x;

    public SccVO2(Value x) {
        super(SccVO2.class, Equatability.SAME_CONCRETE_CLASS);
        this.x = x;
    }

    public static SccVO2 random() {
        return new SccVO2(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}
//@formatter:on
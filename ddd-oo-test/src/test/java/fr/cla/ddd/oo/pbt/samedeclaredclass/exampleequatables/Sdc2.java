package fr.cla.ddd.oo.pbt.samedeclaredclass.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class Sdc2 extends Equatable<Sdc2> {

    protected final Value x;

    public Sdc2(Value x) {
        super(Sdc2.class, Equatability.SAME_DECLARED_CLASS);
        this.x = x;
    }

    public Sdc2(Class<? extends Sdc2> type, Value x) {
        super(type, Equatability.SAME_DECLARED_CLASS);
        this.x = x;
    }

    public static Sdc2 random() {
        return new Sdc2(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}
//@formatter:on
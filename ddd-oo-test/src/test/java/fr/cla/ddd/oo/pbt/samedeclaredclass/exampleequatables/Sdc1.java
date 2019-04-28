package fr.cla.ddd.oo.pbt.samedeclaredclass.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class Sdc1 extends Equatable<Sdc1> {

    protected final Value x;

    public Sdc1(Value x) {
        super(Sdc1.class, Equatability.SAME_DECLARED_CLASS);
        this.x = x;
    }

    public Sdc1(Class<? extends Sdc1> type, Value x) {
        super(type, Equatability.SAME_DECLARED_CLASS);
        this.x = x;
    }

    public static Sdc1 random() {
        return new Sdc1(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}
//@formatter:on
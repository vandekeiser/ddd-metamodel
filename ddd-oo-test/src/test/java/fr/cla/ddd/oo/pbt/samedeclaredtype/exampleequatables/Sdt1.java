package fr.cla.ddd.oo.pbt.samedeclaredtype.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;


public class Sdt1 extends Equatable<Sdt1> {

    protected final Value x;

    public Sdt1(Value x) {
        super(Sdt1.class, Equatability.SAME_DECLARED_CLASS);
        this.x = x;
    }

    public Sdt1(Class<? extends Sdt1> type, Value x) {
        super(type, Equatability.SAME_DECLARED_CLASS);
        this.x = x;
    }

    public static Sdt1 random() {
        return new Sdt1(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}

package fr.cla.ddd.oo.pbt.samedeclaredtype.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;


public class Sdt2 extends Equatable<Sdt2> {

    protected final Value x;

    public Sdt2(Value x) {
        super(Sdt2.class, Equatability.SAME_DECLARED_CLASS);
        this.x = x;
    }

    public Sdt2(Class<? extends Sdt2> type, Value x) {
        super(type, Equatability.SAME_DECLARED_CLASS);
        this.x = x;
    }

    public static Sdt2 random() {
        return new Sdt2(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}

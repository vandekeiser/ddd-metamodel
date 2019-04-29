package fr.cla.ddd.oo.pbt.isinstance.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;


public class Ii1 extends Equatable<Ii1> {

    protected final Value x;

    public Ii1(Value x) {
        super(Ii1.class, Equatability.IS_INSTANCE);
        this.x = x;
    }

    public Ii1(Class<? extends Ii1> type, Value x) {
        super(type, Equatability.IS_INSTANCE);
        this.x = x;
    }

    public static Ii1 random() {
        return new Ii1(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}

package fr.cla.ddd.oo.pbt.isinstance.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;


public class Ii2 extends Equatable<Ii2> {

    protected final Value x;

    public Ii2(Value x) {
        super(Ii2.class, Equatability.IS_INSTANCE);
        this.x = x;
    }

    public Ii2(Class<? extends Ii2> type, Value x) {
        super(type, Equatability.IS_INSTANCE);
        this.x = x;
    }

    public static Ii2 random() {
        return new Ii2(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}

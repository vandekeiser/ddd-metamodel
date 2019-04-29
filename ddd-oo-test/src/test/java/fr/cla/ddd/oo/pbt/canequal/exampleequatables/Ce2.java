package fr.cla.ddd.oo.pbt.canequal.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;


public class Ce2 extends Equatable<Ce2> {

    protected final Value x;

    public Ce2(Value x) {
        super(Ce2.class, Equatability.CAN_EQUAL);
        this.x = x;
    }

    public Ce2(Class<? extends Ce2> type, Value x) {
        super(type, Equatability.CAN_EQUAL);
        this.x = x;
    }

    public static Ce2 random() {
        return new Ce2(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

    @Override
    public boolean canEqual(Equatable<?> that) {
        return that instanceof Ce2;
    }

}

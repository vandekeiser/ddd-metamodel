package fr.cla.ddd.oo.pbt.canequal.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;


public class Ce1 extends Equatable<Ce1> {

    protected final Value x;

    public Ce1(Value x) {
        super(Ce1.class, Equatability.CAN_EQUAL);
        this.x = x;
    }

    public Ce1(Class<? extends Ce1> type, Value x) {
        super(type, Equatability.CAN_EQUAL);
        this.x = x;
    }

    public static Ce1 random() {
        return new Ce1(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

    @Override
    public boolean canEqual(Equatable<?> that) {
        return that instanceof Ce1;
    }

}

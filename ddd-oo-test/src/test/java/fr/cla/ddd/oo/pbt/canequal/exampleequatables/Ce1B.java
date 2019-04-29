package fr.cla.ddd.oo.pbt.canequal.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public class Ce1B extends Ce1 {

    private final Value y;

    public Ce1B(Value y, Value x) {
        super(Ce1B.class, x);
        this.y = y;
    }

    public static Ce1B random() {
        return new Ce1B(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

    @Override
    public boolean canEqual(Equatable<?> that) {
        return that instanceof Ce1B;
    }

}

package fr.cla.ddd.oo.pbt.canequal.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public class Ce2B extends Ce2 {

    private final Value y;

    public Ce2B(Value y, Value x) {
        super(Ce2B.class, x);
        this.y = y;
    }

    public static Ce2B random() {
        return new Ce2B(
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
        return that instanceof Ce2B;
    }

}

package fr.cla.ddd.oo.pbt.canequal.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public class Ce2A extends Ce2 {

    private final Value y;

    public Ce2A(Value y, Value x) {
        super(Ce2A.class, x);
        this.y = y;
    }

    public static Ce2A random() {
        return new Ce2A(
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
        return that instanceof Ce2A;
    }

}
//@formatter:on
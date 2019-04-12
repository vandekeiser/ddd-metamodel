package fr.cla.ddd.oo.exampleequatables.sameconcreteclass;

import fr.cla.ddd.oo.exampleequatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class SccVO2A extends SccVO2 {

    private final Value y;

    public SccVO2A(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static SccVO2A random() {
        return new SccVO2A(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}
//@formatter:on
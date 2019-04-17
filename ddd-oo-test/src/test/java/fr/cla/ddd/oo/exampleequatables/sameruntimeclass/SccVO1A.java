package fr.cla.ddd.oo.exampleequatables.sameruntimeclass;

import fr.cla.ddd.oo.exampleequatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class SccVO1A extends SccVO1 {

    private final Value y;

    public SccVO1A(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static SccVO1A random() {
        return new SccVO1A(
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
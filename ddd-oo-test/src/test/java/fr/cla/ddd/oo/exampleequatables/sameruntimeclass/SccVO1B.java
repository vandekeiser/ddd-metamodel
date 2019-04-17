package fr.cla.ddd.oo.exampleequatables.sameruntimeclass;

import fr.cla.ddd.oo.exampleequatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class SccVO1B extends SccVO1 {

    private final Value y;

    public SccVO1B(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static SccVO1B random() {
        return new SccVO1B(
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
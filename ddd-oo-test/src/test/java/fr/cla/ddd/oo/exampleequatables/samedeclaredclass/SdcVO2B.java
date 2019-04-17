package fr.cla.ddd.oo.exampleequatables.samedeclaredclass;

import fr.cla.ddd.oo.exampleequatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class SdcVO2B extends SdcVO2 {

    private final Value y;

    public SdcVO2B(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static SdcVO2B random() {
        return new SdcVO2B(
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
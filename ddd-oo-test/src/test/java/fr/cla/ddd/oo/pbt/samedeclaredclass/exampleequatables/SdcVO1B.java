package fr.cla.ddd.oo.pbt.samedeclaredclass.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class SdcVO1B extends SdcVO1 {

    private final Value y;

    public SdcVO1B(Value y, Value x) {
        super(SdcVO1B.class, x);
        this.y = y;
    }

    public static SdcVO1B random() {
        return new SdcVO1B(
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
package fr.cla.ddd.oo.exampleequatables.samedeclaredclass;

import fr.cla.ddd.oo.exampleequatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class SdcVO1A extends SdcVO1 {

    private final Value y;

    public SdcVO1A(Value y, Value x) {
        super(SdcVO1A.class, x);
        this.y = y;
    }

    public static SdcVO1A random() {
        return new SdcVO1A(
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
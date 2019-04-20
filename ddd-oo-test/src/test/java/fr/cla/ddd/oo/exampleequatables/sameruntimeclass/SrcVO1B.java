package fr.cla.ddd.oo.exampleequatables.sameruntimeclass;

import fr.cla.ddd.oo.exampleequatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class SrcVO1B extends SrcVO1 {

    private final Value y;

    public SrcVO1B(Value y, Value x) {
        super(SrcVO1B.class, x);
        this.y = y;
    }

    public static SrcVO1B random() {
        return new SrcVO1B(
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
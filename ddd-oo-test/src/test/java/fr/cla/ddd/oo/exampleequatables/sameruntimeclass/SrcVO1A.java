package fr.cla.ddd.oo.exampleequatables.sameruntimeclass;

import fr.cla.ddd.oo.exampleequatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class SrcVO1A extends SrcVO1 {

    private final Value y;

    public SrcVO1A(Value y, Value x) {
        super(SrcVO1A.class, x);
        this.y = y;
    }

    public static SrcVO1A random() {
        return new SrcVO1A(
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
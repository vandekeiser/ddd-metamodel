package fr.cla.ddd.oo.exampleequatables.sameruntimeclass;

import fr.cla.ddd.oo.exampleequatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class SrcVO2A extends SrcVO2 {

    private final Value y;

    public SrcVO2A(Value y, Value x) {
        super(SrcVO2A.class, x);
        this.y = y;
    }

    public static SrcVO2A random() {
        return new SrcVO2A(
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
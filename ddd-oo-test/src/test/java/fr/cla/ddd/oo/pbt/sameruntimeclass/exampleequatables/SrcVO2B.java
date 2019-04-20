package fr.cla.ddd.oo.pbt.sameruntimeclass.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class SrcVO2B extends SrcVO2 {

    private final Value y;

    public SrcVO2B(Value y, Value x) {
        super(SrcVO2B.class, x);
        this.y = y;
    }

    public static SrcVO2B random() {
        return new SrcVO2B(
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
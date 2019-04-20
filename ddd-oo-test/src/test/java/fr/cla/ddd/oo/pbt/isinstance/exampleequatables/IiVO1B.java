package fr.cla.ddd.oo.pbt.isinstance.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class IiVO1B extends IiVO1 {

    private final Value y;

    public IiVO1B(Value y, Value x) {
        super(IiVO1B.class, x);
        this.y = y;
    }

    public static IiVO1B random() {
        return new IiVO1B(
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
package fr.cla.ddd.oo.exampleequatables.isinstance;

import fr.cla.ddd.oo.exampleequatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class IiVO2A extends IiVO2 {

    private final Value y;

    public IiVO2A(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static IiVO2A random() {
        return new IiVO2A(
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
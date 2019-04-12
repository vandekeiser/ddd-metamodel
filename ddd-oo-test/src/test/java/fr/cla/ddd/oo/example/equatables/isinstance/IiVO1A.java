package fr.cla.ddd.oo.example.equatables.isinstance;

import fr.cla.ddd.oo.example.equatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class IiVO1A extends IiVO1 {

    private final Value y;

    public IiVO1A(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static IiVO1A random() {
        return new IiVO1A(
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
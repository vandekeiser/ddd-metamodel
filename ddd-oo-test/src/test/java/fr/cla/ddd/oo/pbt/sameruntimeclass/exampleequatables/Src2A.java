package fr.cla.ddd.oo.pbt.sameruntimeclass.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class Src2A extends Src2 {

    private final Value y;

    public Src2A(Value y, Value x) {
        super(Src2A.class, x);
        this.y = y;
    }

    public static Src2A random() {
        return new Src2A(
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
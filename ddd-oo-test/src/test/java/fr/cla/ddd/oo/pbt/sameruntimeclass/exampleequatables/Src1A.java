package fr.cla.ddd.oo.pbt.sameruntimeclass.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class Src1A extends Src1 {

    private final Value y;

    public Src1A(Value y, Value x) {
        super(Src1A.class, x);
        this.y = y;
    }

    public static Src1A random() {
        return new Src1A(
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
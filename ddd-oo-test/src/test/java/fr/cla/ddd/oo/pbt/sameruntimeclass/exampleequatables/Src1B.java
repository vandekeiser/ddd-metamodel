package fr.cla.ddd.oo.pbt.sameruntimeclass.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public final class Src1B extends Src1 {

    private final Value y;

    public Src1B(Value y, Value x) {
        super(Src1B.class, x);
        this.y = y;
    }

    public static Src1B random() {
        return new Src1B(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}

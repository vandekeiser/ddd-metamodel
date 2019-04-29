package fr.cla.ddd.oo.pbt.sameruntimeclass.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public final class Src2B extends Src2 {

    private final Value y;

    public Src2B(Value y, Value x) {
        super(Src2B.class, x);
        this.y = y;
    }

    public static Src2B random() {
        return new Src2B(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}

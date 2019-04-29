package fr.cla.ddd.oo.pbt.isinstance.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public final class Ii2B extends Ii2 {

    private final Value y;

    public Ii2B(Value y, Value x) {
        super(Ii2B.class, x);
        this.y = y;
    }

    public static Ii2B random() {
        return new Ii2B(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}

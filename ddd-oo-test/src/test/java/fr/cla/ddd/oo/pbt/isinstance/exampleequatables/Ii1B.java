package fr.cla.ddd.oo.pbt.isinstance.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public final class Ii1B extends Ii1 {

    private final Value y;

    public Ii1B(Value y, Value x) {
        super(Ii1B.class, x);
        this.y = y;
    }

    public static Ii1B random() {
        return new Ii1B(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}

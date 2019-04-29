package fr.cla.ddd.oo.pbt.samedeclaredclass.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public final class Sdc1B extends Sdc1 {

    private final Value y;

    public Sdc1B(Value y, Value x) {
        super(Sdc1B.class, x);
        this.y = y;
    }

    public static Sdc1B random() {
        return new Sdc1B(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}

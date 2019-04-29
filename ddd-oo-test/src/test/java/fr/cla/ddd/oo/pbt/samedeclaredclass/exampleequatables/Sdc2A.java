package fr.cla.ddd.oo.pbt.samedeclaredclass.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public final class Sdc2A extends Sdc2 {

    private final Value y;

    public Sdc2A(Value y, Value x) {
        super(Sdc2A.class, x);
        this.y = y;
    }

    public static Sdc2A random() {
        return new Sdc2A(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}

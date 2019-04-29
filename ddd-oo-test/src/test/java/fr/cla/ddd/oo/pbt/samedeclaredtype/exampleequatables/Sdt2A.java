package fr.cla.ddd.oo.pbt.samedeclaredtype.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public final class Sdt2A extends Sdt2 {

    private final Value y;

    public Sdt2A(Value y, Value x) {
        super(Sdt2A.class, x);
        this.y = y;
    }

    public static Sdt2A random() {
        return new Sdt2A(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}

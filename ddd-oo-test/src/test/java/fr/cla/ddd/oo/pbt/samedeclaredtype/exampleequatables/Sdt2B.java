package fr.cla.ddd.oo.pbt.samedeclaredtype.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public final class Sdt2B extends Sdt2 {

    private final Value y;

    public Sdt2B(Value y, Value x) {
        super(Sdt2B.class, x);
        this.y = y;
    }

    public static Sdt2B random() {
        return new Sdt2B(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}

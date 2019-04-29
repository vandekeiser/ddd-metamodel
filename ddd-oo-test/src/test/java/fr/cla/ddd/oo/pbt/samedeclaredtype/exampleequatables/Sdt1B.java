package fr.cla.ddd.oo.pbt.samedeclaredtype.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public final class Sdt1B extends Sdt1 {

    private final Value y;

    public Sdt1B(Value y, Value x) {
        super(Sdt1B.class, x);
        this.y = y;
    }

    public static Sdt1B random() {
        return new Sdt1B(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}

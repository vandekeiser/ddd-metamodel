package fr.cla.ddd.oo.pbt.samedeclaredtype.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public final class Sdt1A extends Sdt1 {

    private final Value y;

    public Sdt1A(Value y, Value x) {
        super(Sdt1A.class, x);
        this.y = y;
    }

    public static Sdt1A random() {
        return new Sdt1A(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}

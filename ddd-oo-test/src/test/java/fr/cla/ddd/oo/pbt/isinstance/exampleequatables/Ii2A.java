package fr.cla.ddd.oo.pbt.isinstance.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class Ii2A extends Ii2 {

    private final Value y;

    public Ii2A(Value y, Value x) {
        super(Ii2A.class, x);
        this.y = y;
    }

    public static Ii2A random() {
        return new Ii2A(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}
//@formatter:on
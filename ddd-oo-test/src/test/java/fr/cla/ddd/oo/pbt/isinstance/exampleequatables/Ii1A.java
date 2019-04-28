package fr.cla.ddd.oo.pbt.isinstance.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class Ii1A extends Ii1 {

    private final Value y;

    public Ii1A(Value y, Value x) {
        super(Ii1A.class, x);
        this.y = y;
    }

    public static Ii1A random() {
        return new Ii1A(
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
package fr.cla.ddd.oo.pbt.samedeclaredclass.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class Sdc2B extends Sdc2 {

    private final Value y;

    public Sdc2B(Value y, Value x) {
        super(Sdc2B.class, x);
        this.y = y;
    }

    public static Sdc2B random() {
        return new Sdc2B(
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
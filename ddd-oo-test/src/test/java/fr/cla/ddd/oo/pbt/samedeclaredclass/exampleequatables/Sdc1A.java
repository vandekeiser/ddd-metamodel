package fr.cla.ddd.oo.pbt.samedeclaredclass.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class Sdc1A extends Sdc1 {

    private final Value y;

    public Sdc1A(Value y, Value x) {
        super(Sdc1A.class, x);
        this.y = y;
    }

    public static Sdc1A random() {
        return new Sdc1A(
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
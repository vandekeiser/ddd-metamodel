package fr.cla.ddd.oo.example.equatables.canequal;

import fr.cla.ddd.oo.example.equatables.Value;
import fr.cla.ddd.oo.Equatable;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public class CeVO2A extends CeVO2 {

    private final Value y;

    public CeVO2A(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static CeVO2A random() {
        return new CeVO2A(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

    @Override
    protected boolean canEqual(Equatable<?> that) {
        return that instanceof CeVO2A;
    }

}
//@formatter:on
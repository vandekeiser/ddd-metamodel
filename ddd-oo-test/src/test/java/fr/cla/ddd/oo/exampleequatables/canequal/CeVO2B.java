package fr.cla.ddd.oo.exampleequatables.canequal;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public class CeVO2B extends CeVO2 {

    private final Value y;

    public CeVO2B(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static CeVO2B random() {
        return new CeVO2B(
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
        return that instanceof CeVO2B;
    }

}
//@formatter:on
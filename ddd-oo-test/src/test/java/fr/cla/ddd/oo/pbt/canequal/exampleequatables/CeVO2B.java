package fr.cla.ddd.oo.pbt.canequal.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public class CeVO2B extends CeVO2 {

    private final Value y;

    public CeVO2B(Value y, Value x) {
        super(CeVO2B.class, x);
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
    public boolean canEqual(Equatable<?> that) {
        return that instanceof CeVO2B;
    }

}
//@formatter:on
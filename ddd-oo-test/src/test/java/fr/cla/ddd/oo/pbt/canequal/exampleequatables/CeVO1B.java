package fr.cla.ddd.oo.pbt.canequal.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public class CeVO1B extends CeVO1 {

    private final Value y;

    public CeVO1B(Value y, Value x) {
        super(CeVO1B.class, x);
        this.y = y;
    }

    public static CeVO1B random() {
        return new CeVO1B(
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
        return that instanceof CeVO1B;
    }

}
//@formatter:on
package fr.cla.ddd.oo.exampleequatables.canequal;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public class CeVO1B extends CeVO1 {

    private final Value y;

    public CeVO1B(Value y, Value x) {
        //Note that i pass the parent class to be able to cast both CeVO1 and CeVO1B to CeVO1
        // (since equals must be symmetric )
        super(CeVO1.class, x);
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
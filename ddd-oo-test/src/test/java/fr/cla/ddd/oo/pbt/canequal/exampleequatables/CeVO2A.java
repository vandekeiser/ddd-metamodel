package fr.cla.ddd.oo.pbt.canequal.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public class CeVO2A extends CeVO2 {

    private final Value y;

    public CeVO2A(Value y, Value x) {
        //Note that i pass the parent class to be able to cast both CeVO1 and CeVO1B to CeVO1
        // (since equals must be symmetric )
        super(CeVO2.class, x);
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
    public boolean canEqual(Equatable<?> that) {
        return that instanceof CeVO2A;
    }

}
//@formatter:on
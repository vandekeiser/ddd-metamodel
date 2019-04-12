package fr.cla.ddd.oo.example.equatables.canequal;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.example.equatables.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class CeVO2 extends Equatable<CeVO2> {

    protected final Value x;

    public CeVO2(Value x) {
        super(CeVO2.class, Equatability.CAN_EQUAL);
        this.x = x;
    }

    public static CeVO2 random() {
        return new CeVO2(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

    @Override
    protected boolean canEqual(Equatable<?> that) {
        return that instanceof CeVO2;
    }

}
//@formatter:on
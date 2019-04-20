package fr.cla.ddd.oo.pbt.canequal.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class CeVO1 extends Equatable<CeVO1> {

    protected final Value x;

    public CeVO1(Value x) {
        super(CeVO1.class, Equatability.CAN_EQUAL);
        this.x = x;
    }

    public CeVO1(Class<? extends CeVO1> type, Value x) {
        super(type, Equatability.CAN_EQUAL);
        this.x = x;
    }

    public static CeVO1 random() {
        return new CeVO1(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

    @Override
    public boolean canEqual(Equatable<?> that) {
        return that instanceof CeVO1;
    }

}
//@formatter:on
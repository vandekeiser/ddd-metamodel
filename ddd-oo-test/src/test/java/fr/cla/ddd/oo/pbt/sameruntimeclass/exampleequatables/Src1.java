package fr.cla.ddd.oo.pbt.sameruntimeclass.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;


public class Src1 extends Equatable<Src1> {

    protected final Value x;

    public Src1(Value x) {
        super(Src1.class, Equatability.SAME_RUNTIME_CLASS);
        this.x = x;
    }

    public Src1(Class<? extends Src1> type, Value x) {
        super(type, Equatability.SAME_RUNTIME_CLASS);
        this.x = x;
    }

    public static Src1 random() {
        return new Src1(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}

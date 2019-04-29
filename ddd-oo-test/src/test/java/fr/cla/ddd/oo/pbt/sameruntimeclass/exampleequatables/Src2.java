package fr.cla.ddd.oo.pbt.sameruntimeclass.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;


public class Src2 extends Equatable<Src2> {

    protected final Value x;

    public Src2(Value x) {
        super(Src2.class, Equatability.SAME_RUNTIME_CLASS);
        this.x = x;
    }

    public Src2(Class<? extends Src2> type, Value x) {
        super(type, Equatability.SAME_RUNTIME_CLASS);
        this.x = x;
    }

    public static Src2 random() {
        return new Src2(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}

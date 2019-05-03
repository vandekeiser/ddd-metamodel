package fr.cla.ddd.oo.pbt.sameruntimetype.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;


public class Srt1 extends Equatable<Srt1> {

    protected final Value x;

    public Srt1(Value x) {
        super(Srt1.class, Equatability.SAME_RUNTIME_TYPE);
        this.x = x;
    }

    public Srt1(Class<? extends Srt1> type, Value x) {
        super(type, Equatability.SAME_RUNTIME_TYPE);
        this.x = x;
    }

    public static Srt1 random() {
        return new Srt1(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}

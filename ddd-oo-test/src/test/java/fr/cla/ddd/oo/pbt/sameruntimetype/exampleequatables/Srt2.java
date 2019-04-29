package fr.cla.ddd.oo.pbt.sameruntimetype.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;


public class Srt2 extends Equatable<Srt2> {

    protected final Value x;

    public Srt2(Value x) {
        super(Srt2.class, Equatability.SAME_RUNTIME_CLASS);
        this.x = x;
    }

    public Srt2(Class<? extends Srt2> type, Value x) {
        super(type, Equatability.SAME_RUNTIME_CLASS);
        this.x = x;
    }

    public static Srt2 random() {
        return new Srt2(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}

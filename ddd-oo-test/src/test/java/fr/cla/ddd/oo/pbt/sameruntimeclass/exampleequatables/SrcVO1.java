package fr.cla.ddd.oo.pbt.sameruntimeclass.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class SrcVO1 extends Equatable<SrcVO1> {

    protected final Value x;

    public SrcVO1(Value x) {
        super(SrcVO1.class, Equatability.SAME_RUNTIME_CLASS);
        this.x = x;
    }

    public SrcVO1(Class<? extends SrcVO1> type, Value x) {
        super(type, Equatability.SAME_RUNTIME_CLASS);
        this.x = x;
    }

    public static SrcVO1 random() {
        return new SrcVO1(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}
//@formatter:on
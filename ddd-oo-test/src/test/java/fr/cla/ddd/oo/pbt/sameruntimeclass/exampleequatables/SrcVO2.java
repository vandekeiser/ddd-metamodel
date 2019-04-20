package fr.cla.ddd.oo.pbt.sameruntimeclass.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class SrcVO2 extends Equatable<SrcVO2> {

    protected final Value x;

    public SrcVO2(Value x) {
        super(SrcVO2.class, Equatability.SAME_RUNTIME_CLASS);
        this.x = x;
    }

    public SrcVO2(Class<? extends SrcVO2> type, Value x) {
        super(type, Equatability.SAME_RUNTIME_CLASS);
        this.x = x;
    }

    public static SrcVO2 random() {
        return new SrcVO2(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}
//@formatter:on
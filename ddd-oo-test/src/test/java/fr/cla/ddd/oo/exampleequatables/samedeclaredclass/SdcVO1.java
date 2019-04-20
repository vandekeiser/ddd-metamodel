package fr.cla.ddd.oo.exampleequatables.samedeclaredclass;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.Value;
import fr.cla.ddd.oo.exampleequatables.isinstance.IiVO1;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class SdcVO1 extends Equatable<SdcVO1> {

    protected final Value x;

    public SdcVO1(Value x) {
        super(SdcVO1.class, Equatability.SAME_DECLARED_CLASS);
        this.x = x;
    }

    public SdcVO1(Class<? extends SdcVO1> type, Value x) {
        super(type, Equatability.SAME_DECLARED_CLASS);
        this.x = x;
    }

    public static SdcVO1 random() {
        return new SdcVO1(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}
//@formatter:on
package fr.cla.ddd.oo.exampleequatables.samedeclaredclass;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class SdcVO2 extends Equatable<SdcVO2> {

    protected final Value x;

    public SdcVO2(Value x) {
        super(SdcVO2.class, Equatability.SAME_DECLARED_CLASS);
        this.x = x;
    }

    public static SdcVO2 random() {
        return new SdcVO2(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}
//@formatter:on
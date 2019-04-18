package fr.cla.ddd.oo.exampleequatables.isinstance;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class IiVO1 extends Equatable<IiVO1> {

    protected final Value x;

    public IiVO1(Value x) {
        super(IiVO1.class, Equatability.IS_INSTANCE);
        this.x = x;
    }

    public IiVO1(Class<? extends IiVO1> type, Value x) {
        super(type, Equatability.IS_INSTANCE);
        this.x = x;
    }

    public static IiVO1 random() {
        return new IiVO1(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}
//@formatter:on
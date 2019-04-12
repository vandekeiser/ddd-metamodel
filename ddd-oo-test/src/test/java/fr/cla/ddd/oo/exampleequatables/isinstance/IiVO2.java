package fr.cla.ddd.oo.exampleequatables.isinstance;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class IiVO2 extends Equatable<IiVO2> {

    protected final Value x;

    public IiVO2(Value x) {
        super(IiVO2.class, Equatability.IS_INSTANCE);
        this.x = x;
    }

    public static IiVO2 random() {
        return new IiVO2(Value.random());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}
//@formatter:on
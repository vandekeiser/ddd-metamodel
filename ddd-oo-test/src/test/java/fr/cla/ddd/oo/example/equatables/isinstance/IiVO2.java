package fr.cla.ddd.oo.example.equatables.isinstance;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.example.equatables.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class IiVO2 extends Equatable<IiVO2> {

    protected final Value x;

    public IiVO2(Value x) {
        super(IiVO2.class, Equatability.IS_INSTANCE);
        this.x = x;
    }

    public static IiVO2 random(SourceOfRandomness rand) {
        return new IiVO2(Value.random(rand));
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

}
//@formatter:on
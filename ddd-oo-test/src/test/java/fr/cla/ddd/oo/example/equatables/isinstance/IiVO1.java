package fr.cla.ddd.oo.example.equatables.isinstance;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.example.equatables.Value;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class IiVO1 extends Equatable<IiVO1> {

    protected final Value x;

    public IiVO1(Value x) {
        super(IiVO1.class, Equatability.IS_INSTANCE);
        this.x = x;
    }

    public static IiVO1 random(SourceOfRandomness rand) {
        return new IiVO1(Value.random(rand));
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
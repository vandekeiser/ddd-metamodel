package fr.cla.ddd.oo.example.equatables.isinstance;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.example.equatables.Value;

import java.util.Arrays;
import java.util.List;

//@formatter:off
public final class IiVO2B extends IiVO2 {

    private final Value y;

    public IiVO2B(Value y, Value x) {
        super(x);
        this.y = y;
    }

    public static IiVO2B random(SourceOfRandomness rand) {
        return new IiVO2B(
            Value.random(rand),
            Value.random(rand)
        );
    }

    public static IiVO2B random() {
        return new IiVO2B(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}
//@formatter:on
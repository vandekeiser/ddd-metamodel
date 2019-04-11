package fr.cla.ddd.oo.example.equatables.canequal;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.example.equatables.Value;
import fr.cla.ddd.oo.Equatable;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
public class CeVO2 extends Equatable<CeVO2> {

    protected final Value x;

    public CeVO2(Value x) {
        super(CeVO2.class, Equatability.CAN_EQUAL);
        this.x = x;
    }

    public static CeVO2 random(SourceOfRandomness rand) {
        return new CeVO2(Value.random(rand));
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(x);
    }

    @Override
    protected boolean canEqual(Equatable<?> that) {
        return that instanceof CeVO2;
    }

}
//@formatter:on
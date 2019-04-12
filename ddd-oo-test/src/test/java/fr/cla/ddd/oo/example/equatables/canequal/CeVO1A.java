package fr.cla.ddd.oo.example.equatables.canequal;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import fr.cla.ddd.oo.example.equatables.Value;
import fr.cla.ddd.oo.Equatable;

//@formatter:off
/**
 * Extends CeVO1 but doesn't add state so it can equal the base class without breaking the symmetry of equals.
 */
public final class CeVO1A extends CeVO1 {

    public CeVO1A(Value x) {
        super(x);
    }

    public static CeVO1A random() {
        return new CeVO1A(
            Value.random()
        );
    }

//    Does __NOT__ override equalityCriteria, see class doc.
//    @Override
//    protected List<Object> equalityCriteria() {
//        throw new UnsupportedOperationException();
//    }

    /**
     * Therefore we can do this (it would rarely be useful though)
     */
    @Override
    protected boolean canEqual(Equatable<?> that) {
        return that instanceof CeVO1;
    }

}
//@formatter:on
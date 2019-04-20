package fr.cla.ddd.oo.exampleequatables.canequal;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.exampleequatables.Value;

//@formatter:off
/**
 * Extends CeVO1 but doesn't add state so it can equal the base class without breaking the symmetry of equals.
 */
public final class CeVO1A extends CeVO1 {

    public CeVO1A(Value x) {
        //Note that i pass the parent class to be able to cast both CeVO1 and CeVO1B to CeVO1
        // (since equals must be symmetric )
        super(CeVO1.class, x);
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
    public boolean canEqual(Equatable<?> that) {
        return that instanceof CeVO1;
    }

}
//@formatter:on
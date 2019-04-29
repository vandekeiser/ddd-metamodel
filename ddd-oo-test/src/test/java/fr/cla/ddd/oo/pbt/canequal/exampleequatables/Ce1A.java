package fr.cla.ddd.oo.pbt.canequal.exampleequatables;

import fr.cla.ddd.oo.Equatable;
import fr.cla.ddd.oo.pbt.Value;


/**
 * Extends Ce1 but doesn't add state so it can equal the base class without breaking the symmetry of equals.
 */
public final class Ce1A extends Ce1 {

    public Ce1A(Value x) {
        super(Ce1A.class, x);
    }

    public static Ce1A random() {
        return new Ce1A(
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
        return that instanceof Ce1;
    }

}

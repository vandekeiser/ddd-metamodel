package fr.cla.ddd.metamodel.pbt;

import fr.cla.ddd.metamodel.AbstractValueObject;

import static java.util.Objects.requireNonNull;

//@formatter:off
public class VoPair {

    public final AbstractValueObject<?> x, y;

    public VoPair(AbstractValueObject<?> x, AbstractValueObject<?> y) {
        this.x = requireNonNull(x);
        this.y = requireNonNull(y);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
//@formatter:oN
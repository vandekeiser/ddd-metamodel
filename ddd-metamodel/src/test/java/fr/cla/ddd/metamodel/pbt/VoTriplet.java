package fr.cla.ddd.metamodel.pbt;

import fr.cla.ddd.metamodel.AbstractValueObject;

import static java.util.Objects.requireNonNull;

//@formatter:off
public class VoTriplet {

    public final AbstractValueObject<?> x, y, z;

    public VoTriplet(AbstractValueObject<?> x, AbstractValueObject<?> y, AbstractValueObject<?> z) {
        this.x = requireNonNull(x);
        this.y = requireNonNull(y);
        this.z = requireNonNull(z);
    }

}
//@formatter:oN
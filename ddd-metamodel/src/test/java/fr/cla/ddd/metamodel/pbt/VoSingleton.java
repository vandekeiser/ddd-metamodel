package fr.cla.ddd.metamodel.pbt;

import fr.cla.ddd.metamodel.AbstractValueObject;

import static java.util.Objects.requireNonNull;

//@formatter:off
public class VoSingleton {

    public final AbstractValueObject<?> x;

    public VoSingleton(AbstractValueObject<?> x) {
        this.x = requireNonNull(x);
    }

}
//@formatter:oN
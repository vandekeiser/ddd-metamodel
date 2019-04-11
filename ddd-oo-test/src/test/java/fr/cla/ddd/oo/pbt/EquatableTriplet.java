package fr.cla.ddd.oo.pbt;

import fr.cla.ddd.oo.Equatable;

import static java.util.Objects.requireNonNull;

//@formatter:off
public class EquatableTriplet {

    public final Equatable<?> x, y, z;

    public EquatableTriplet(Equatable<?> x, Equatable<?> y, Equatable<?> z) {
        this.x = requireNonNull(x);
        this.y = requireNonNull(y);
        this.z = requireNonNull(z);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", x, y, z);
    }

}
//@formatter:oN
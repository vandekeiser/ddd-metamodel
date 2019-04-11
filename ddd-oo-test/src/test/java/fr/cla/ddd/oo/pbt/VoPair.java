package fr.cla.ddd.oo.pbt;

import fr.cla.ddd.oo.Equatable;

import static java.util.Objects.requireNonNull;

//@formatter:off
public class VoPair {

    public final Equatable<?> x, y;

    public VoPair(Equatable<?> x, Equatable<?> y) {
        this.x = requireNonNull(x);
        this.y = requireNonNull(y);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
//@formatter:oN
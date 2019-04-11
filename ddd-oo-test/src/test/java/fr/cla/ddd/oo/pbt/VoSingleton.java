package fr.cla.ddd.oo.pbt;

import fr.cla.ddd.oo.Equatable;

import static java.util.Objects.requireNonNull;

//@formatter:off
public class VoSingleton {

    public final Equatable<?> x;

    public VoSingleton(Equatable<?> x) {
        this.x = requireNonNull(x);
    }

    @Override
    public String toString() {
        return x.toString();
    }

}
//@formatter:oN
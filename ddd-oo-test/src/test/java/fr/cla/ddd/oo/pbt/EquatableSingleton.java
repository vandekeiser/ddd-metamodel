package fr.cla.ddd.oo.pbt;

import fr.cla.ddd.oo.Equatable;

import static java.util.Objects.requireNonNull;


public class EquatableSingleton {

    public final Equatable<?> x;

    public EquatableSingleton(Equatable<?> x) {
        this.x = requireNonNull(x);
    }

    @Override
    public String toString() {
        return x.toString();
    }

}

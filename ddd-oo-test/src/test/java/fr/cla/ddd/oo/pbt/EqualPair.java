package fr.cla.ddd.oo.pbt;

import fr.cla.ddd.oo.Equatable;

import java.util.Objects;

public class EqualPair extends EquatablePair {

    public EqualPair(Equatable<?> x, Equatable<?> y) {
        super(x, y);
        validate();
    }

    private void validate() {
        if(!Objects.equals(x, y)) throw new IllegalArgumentException(String.format(
            "%s and %s are not equal", x, y
        ));
    }

}

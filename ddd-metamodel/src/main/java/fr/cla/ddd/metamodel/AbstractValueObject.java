package fr.cla.ddd.metamodel;

//@formatter:off

import fr.cla.ddd.oo.Equatable;

/**
 * A DDD Value Object: immutable object with no identity (equality defined by a set of fields).
 * (here it doesn't include mandatory validation).
 * Compared to Equatable, it adds to the contract that sub-types must be immutable.
 */
public abstract class AbstractValueObject<T extends AbstractValueObject<T>>
extends Equatable<T> {


    protected AbstractValueObject(Class<T> type) {
        super(type);
    }

    protected AbstractValueObject(Class<T> type, Equatability equatability) {
        super(type, equatability);
    }

}
//@formatter:on

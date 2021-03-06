package fr.cla.ddd.metamodel.domain;

import fr.cla.ddd.metamodel.domain.validation.InvalidObjectException;
import fr.cla.ddd.metamodel.domain.validation.Validable;
import fr.cla.ddd.oo.Equatable;


/**
 * A DDD Value Object: immutable object with no identity (equality defined by a set of fields).
 * (here it doesn't include mandatory validation).
 * Compared to Equatable, it adds to the contract that sub-types must be immutable.
 */
public abstract class AbstractValueObject<T extends AbstractValueObject<T>>
extends Equatable<T>
implements Validable<T> {

    protected AbstractValueObject(Class<T> type) throws InvalidObjectException {
        super(type);
        //Can't call validate here unfortunately, since one must not call a virtual method from the constructor.
    }

    protected AbstractValueObject(Class<T> type, Equatability equatability) throws InvalidObjectException {
        super(type, equatability);
        //See above.
    }

}


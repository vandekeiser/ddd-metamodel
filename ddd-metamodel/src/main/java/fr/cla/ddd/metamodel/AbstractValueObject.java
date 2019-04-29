package fr.cla.ddd.metamodel;

import fr.cla.ddd.metamodel.validation.Validation;
import fr.cla.ddd.metamodel.validation.Validator;
import fr.cla.ddd.oo.Equatable;

//@formatter:off
/**
 * A DDD Value Object: immutable object with no identity (equality defined by a set of fields).
 * (here it doesn't include mandatory validation).
 * Compared to Equatable, it adds to the contract that sub-types must be immutable.
 */
@DDD.ValueObject
public abstract class AbstractValueObject<T extends AbstractValueObject<T>>
extends Equatable<T> {

    protected AbstractValueObject(Class<T> type) {
        super(type);
        //Can't call validate here unfortunately, since one must not call a virtual method from the constructor.
    }

    protected AbstractValueObject(Class<T> type, Equatability equatability) {
        super(type, equatability);
        //See above.
    }

    protected final void validate() {
        Validation<T> v = validator().validate(asDeclaredType());
        v.get();
    }

    protected abstract Validator<? super T> validator();

}
//@formatter:on

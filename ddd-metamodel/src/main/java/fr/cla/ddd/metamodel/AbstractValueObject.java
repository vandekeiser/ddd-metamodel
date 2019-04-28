package fr.cla.ddd.metamodel;

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
        //
//        If you perform a virtual method call in a Base constructor
//        and the virtual method is overridden by the Derived class,
//        then the given override of the Derived class is executed before the Derived constructor call
//        (like in case of C#)
//        and before the initialization of any Derived class member variables
//        (this is different from C#!)
//        so the Derived class member variables still hold their zero initialized default value
//        at the time of this method call
//        validator().validate(type.cast(this));
    }

    protected AbstractValueObject(Class<T> type, Equatability equatability) {
        super(type, equatability);
//        validator().validate(type.cast(this));
    }

    protected abstract Validator<T> validator();

}
//@formatter:on

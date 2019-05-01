package fr.cla.ddd.metamodel.domain.validation;

import fr.cla.ddd.metamodel.ValidationException;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class Validation<T> {
    private final T t;
    private final List<ValidationException> errors;

    Validation(T t) {
        this.t = requireNonNull(t);
        this.errors = new ArrayList<>();
    }

    public T get() throws InvalidObjectException {
        if(errors.isEmpty()) {
            return t;
        } else {
            InvalidObjectException invalid = new InvalidObjectException(t);
            errors.forEach(invalid::addSuppressed);
            throw invalid;
        }
    }

    Validation<T> validate(Constraint<? super T> constraint) {
        try {
            if (!constraint.getPredicate().test(t)) {
                errors.add(new ConstraintViolatedException(constraint.getMessageIfViolated()));
            }
        } catch (RuntimeException e) {
            errors.add(new UnexpectedExceptionDuringValidationException(e));
        }
        return this;
    }

}


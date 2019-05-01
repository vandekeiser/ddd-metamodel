package fr.cla.ddd.metamodel.domain.validation;

import fr.cla.ddd.metamodel.ValidationException;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class Validation<T> {
    private final T validatedObject;
    private final List<ValidationException> errors;

    Validation(T validatedObject) {
        this.validatedObject = requireNonNull(validatedObject);
        this.errors = new ArrayList<>();
    }

    public T get() throws InvalidObjectException {
        if(errors.isEmpty()) {
            return validatedObject;
        } else {
            InvalidObjectException invalid = new InvalidObjectException(validatedObject);
            errors.forEach(invalid::addSuppressed);
            throw invalid;
        }
    }

    Validation<T> validate(Constraint<? super T> constraint) {
        try {
            if (!constraint.getPredicate().test(validatedObject)) {
                errors.add(new ConstraintViolatedException(constraint.getMessageIfViolated()));
            }
        } catch (RuntimeException e) {
            errors.add(new UnexpectedExceptionDuringValidationException(e));
        }
        return this;
    }

}


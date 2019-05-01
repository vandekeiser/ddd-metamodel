package fr.cla.ddd.metamodel.domain.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

public class Validation<T> {
    private final T t;
    private final List<AbstractValidationException> errors = new ArrayList<>();

    Validation(T t) {
        this.t = requireNonNull(t);
    }

    public T get() throws InvalidObjectException {
        if(errors.isEmpty()) {
            return t;
        }

        InvalidObjectException invalid = new InvalidObjectException(t);
        errors.forEach(invalid::addSuppressed);
        throw invalid;
    }

    Validation<T> validate(Constraint<? super T> constraint) {
        return validate(constraint.getPredicate(), constraint.getMessageIfViolated());
    }

    private Validation<T> validate(Predicate<? super T> predicate, String messageIfViolated) {
        try {
            if (!predicate.test(t)) {
                errors.add(new ConstraintViolatedException(messageIfViolated));
            }
        } catch (RuntimeException e) {
            errors.add(new UnexpectedExceptionDuringValidationException(e));
        }
        return this;
    }

}


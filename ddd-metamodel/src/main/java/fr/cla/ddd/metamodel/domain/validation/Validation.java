package fr.cla.ddd.metamodel.domain.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

public class Validation<T> {
    private final T t;
    private final List<Throwable> errors = new ArrayList<>();

    Validation(T t) {
        this.t = requireNonNull(t);
    }

    public T get() throws ValidationException {
        if(errors.isEmpty()) {
            return t;
        }

        ValidationException invalid = ValidationException.invalidObject(t);
        errors.forEach(invalid::addSuppressed);
        throw invalid;
    }

    Validation<T> validate(ValidationDefinition<? super T> def) {
        return validate(def.getValidation(), def.getMessage());
    }

    private Validation<T> validate(Predicate<? super T> validation, String message) {
        try {
            if (!validation.test(t)) {
                errors.add(ValidationException.invalidPredicate(message));
            }
        } catch (RuntimeException e) {
            errors.add(e);
        }
        return this;
    }

}


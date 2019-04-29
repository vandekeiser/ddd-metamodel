package fr.cla.ddd.metamodel.validation;

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

    public T get() throws IllegalArgumentException {
        if(errors.isEmpty()) {
            return t;
        }

        IllegalArgumentException invalid = new IllegalArgumentException(errorMessageFor(t));
        errors.forEach(invalid::addSuppressed);
        throw invalid;
    }

    private String errorMessageFor(T t) {
        String toString = String.valueOf(t);
        return alreadyHasClassPrefix(toString) ?
            toString :
            t.getClass().getSimpleName() + toString
        ;
    }

    private boolean alreadyHasClassPrefix(String toString) {
        if(toString.startsWith(t.getClass().getSimpleName())) return true;
        if(toString.startsWith(t.getClass().getName())) return true;
        return false;
    }

    Validation<T> validate(ValidationDefinition<? super T> def) {
        return validate(def.getValidation(), def.getMessage());
    }

    private Validation<T> validate(Predicate<? super T> validation, String message) {
        try {
            if (!validation.test(t)) {
                errors.add(new IllegalArgumentException(message));
            }
        } catch (RuntimeException e) {
            errors.add(e);
        }
        return this;
    }

}


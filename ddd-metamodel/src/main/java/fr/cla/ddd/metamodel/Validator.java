package fr.cla.ddd.metamodel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Objects.*;

public class Validator<T> {
    private final T t;
    private final List<Throwable> errors = new ArrayList<>();

    private Validator(T t) {
        this.t = requireNonNull(t);
    }

    public T get() throws IllegalArgumentException {
        if(errors.isEmpty()) {
            return t;
        }
        IllegalArgumentException invalid = new IllegalArgumentException("Invalid: " + t);
        errors.forEach(invalid::addSuppressed);
        throw invalid;
    }

    public Validator<T> validate(Predicate<? super T> validation, String message) {
        try {
            if (!validation.test(t)) {
                errors.add(new IllegalArgumentException(message));
            }
        } catch (RuntimeException e) {
            errors.add(e);
        }
        return this;
    }

    public <U> Validator<T> validate(
        Function<? super T, ? extends U> projection, Predicate<? super U> validation,
        String message
    ) {
        return validate(projection.andThen(validation::test)::apply, message);
    }

    public static <T> Validator<T> of(T t) {
        return new Validator<>(t);
    }
}


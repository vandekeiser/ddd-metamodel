package fr.cla.ddd.metamodel;

import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

public class ValidationDefinition<T> {
    private final Predicate<? super T> validation;
    private final String message;

    public ValidationDefinition(Predicate<? super T> validation, String message) {
        this.validation = requireNonNull(validation);
        this.message = requireNonNull(message);
    }

    public Predicate<? super T> getValidation() {
        return validation;
    }

    public String getMessage() {
        return message;
    }

}


package fr.cla.ddd.metamodel.validation;

import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

class ValidationDefinition<T> {
    private final Predicate<? super T> validation;
    private final String message;

    ValidationDefinition(Predicate<? super T> validation, String message) {
        this.validation = requireNonNull(validation);
        this.message = requireNonNull(message);
    }

    Predicate<? super T> getValidation() {
        return validation;
    }

    String getMessage() {
        return message;
    }

}


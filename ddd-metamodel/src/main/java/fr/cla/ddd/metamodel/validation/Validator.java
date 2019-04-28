package fr.cla.ddd.metamodel.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Validator<T> {
    private final List<ValidationDefinition<T>> validations;

    private Validator() {
        this.validations = new ArrayList<>();
    }

    public static <T> Validator<T> of() {
        return new Validator<>();
    }

    public static <T> Validator<T> of(Class<T> typeUsedForCompilationOnly) {
        return new Validator<>();
    }

    public static <T> Validator<T> none() {
        return new Validator<>();
    }

    /**
     * Validate the object as a whole
     */
    public Validator<T> validate(Predicate<? super T> validation, String message) {
        validations.add(new ValidationDefinition<>(validation, message));
        return this;
    }

    /**
     * Validate a field
     */
    public <U> Validator<T> validate(
        Function<? super T, ? extends U> fieldExtractor,
        Predicate<? super U> validation,
        String message
    ) {
        return validate(
            fieldExtractor.andThen(validation::test)::apply,
            message
        );
    }

    public Validation<T> validate(T object) {
        Validation<T> validation = new Validation<>(object);
        validations.forEach(validation::validate);
        return validation;
    }
}


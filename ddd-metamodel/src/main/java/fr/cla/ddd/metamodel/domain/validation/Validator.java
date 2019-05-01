package fr.cla.ddd.metamodel.domain.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Validator<T> {
    private final List<Constraint<T>> constraints;

    private Validator() {
        this.constraints = new ArrayList<>();
    }

    public static <T> Validator<T> of(Class<T> usedOnlyForTypeInference) {
        return new Validator<>();
    }

    public static <T> Validator<T> none() {
        return new Validator<>();
    }

    /**
     * Cross-field (or general-case) validation
     */
    public Validator<T> validate(Predicate<? super T> validation, String message) {
        constraints.add(new Constraint<>(validation, message));
        return this;
    }

    /**
     * Single-field validation
     */
    public <F> Validator<T> validate(
        Function<? super T, ? extends F> fieldExtractor,
        Predicate<? super F> validation,
        String message
    ) {
        return validate(
            //Rémi Forax technique to convert a lambda from one SAMI to another,
            // from his presentation "Les design patterns à la sauce lambda",
            fieldExtractor.andThen(validation::test)::apply,
            message
        );
    }

    public <S extends T> Validation<S> validate(S object) {
        Validation<S> validation = new Validation<>(object);
        constraints.forEach(validation::validate);
        return validation;
    }

}


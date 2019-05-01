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
    public Validator<T> validate(Predicate<? super T> predicate, String message) {
        constraints.add(new Constraint<>(predicate, message));
        return this;
    }

    /**
     * Single-field validation
     */
    public <F> Validator<T> validate(
        Function<? super T, ? extends F> fieldExtractor,
        Predicate<? super F> predicate,
        String message
    ) {
        return validate(
            fieldExtractor.andThen(predicate::test)::apply,
            message
        );
    }

    public <S extends T> Validation<S> validate(S object) {
        Validation<S> v = new Validation<>(object);
        constraints.forEach(v::validate);
        return v;
    }

}


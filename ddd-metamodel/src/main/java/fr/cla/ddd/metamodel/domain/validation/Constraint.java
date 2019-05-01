package fr.cla.ddd.metamodel.domain.validation;

import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

class Constraint<T> {
    private final Predicate<? super T> predicate;
    private final String messageIfViolated;

    Constraint(Predicate<? super T> predicate, String messageIfViolated) {
        this.predicate = requireNonNull(predicate);
        this.messageIfViolated = requireNonNull(messageIfViolated);
    }

    Predicate<? super T> getPredicate() {
        return predicate;
    }

    String getMessageIfViolated() {
        return messageIfViolated;
    }

}


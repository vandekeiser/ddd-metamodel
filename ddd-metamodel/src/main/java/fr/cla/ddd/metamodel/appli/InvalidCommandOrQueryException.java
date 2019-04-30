package fr.cla.ddd.metamodel.appli;

import fr.cla.ddd.metamodel.domain.validation.ValidationException;

import java.util.Arrays;
import java.util.Optional;

/**
 * A validation exception occurred after the schema validation,
 * during a validation that can only be done by the application.
 * (in other words the invalid data got through the openapi validation,
 * but was detected at the application level)
 */
public class InvalidCommandOrQueryException extends IllegalArgumentException {

    private static final String DEFAULT_MSG = "Invalid command or query";

    private final Object commandOrQuery;

    public InvalidCommandOrQueryException(ValidationException cause, Object commandOrQuery) {
        super(DEFAULT_MSG, cause);
        this.commandOrQuery = commandOrQuery;
    }

    public InvalidCommandOrQueryException(String msg, ValidationException cause, Object commandOrQuery) {
        super(msg, cause);
        this.commandOrQuery = commandOrQuery;
    }

    public Optional<Object> getCommandOrQuery() {
        return Optional.ofNullable(commandOrQuery);
    }

    public ValidationException getValidationCause() {
        return (ValidationException) super.getCause();
    }

    @Override
    public String toString() {
        return String.format(
            "%s:{commandOrQuery: %s, cause:%s, causes: %s}",
            getClass().getSimpleName(), commandOrQuery, getCause(), causes()
        );
    }

    private String causes() {
        return Arrays.toString(getCause().getSuppressed());
    }

}

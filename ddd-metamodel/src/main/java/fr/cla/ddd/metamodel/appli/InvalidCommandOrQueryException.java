package fr.cla.ddd.metamodel.appli;

import fr.cla.ddd.metamodel.domain.validation.AbstractValidationException;
import fr.cla.ddd.metamodel.domain.validation.InvalidObjectException;

import java.util.Arrays;
import java.util.Optional;

/**
 * A validation exception occurred after the schema validation,
 * during a validation that can only be done by the application.
 * (in other words the invalid data got through the openapi validation,
 * but was detected at the application level).
 *
 * It is the only concrete type of AbstractValidationException to be mapped in Exception2HttpStatus,
 * because if the ApplicationService don't do application-level validation, that should be an internal error.
 */
public class InvalidCommandOrQueryException extends AbstractValidationException {

    private static final String DEFAULT_MSG = "Invalid command or query";

    private final Object commandOrQuery;

    public InvalidCommandOrQueryException(InvalidObjectException cause, Object commandOrQuery) {
        super(DEFAULT_MSG, cause);
        this.commandOrQuery = commandOrQuery;
    }

    public InvalidCommandOrQueryException(String msg, InvalidObjectException cause, Object commandOrQuery) {
        super(msg, cause);
        this.commandOrQuery = commandOrQuery;
    }

    public Optional<Object> getCommandOrQuery() {
        return Optional.ofNullable(commandOrQuery);
    }

    public InvalidObjectException getValidationCause() {
        return (InvalidObjectException) super.getCause();
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

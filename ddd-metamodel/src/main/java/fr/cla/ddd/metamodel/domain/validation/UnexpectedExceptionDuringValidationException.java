package fr.cla.ddd.metamodel.domain.validation;

import fr.cla.ddd.metamodel.ValidationException;

public class UnexpectedExceptionDuringValidationException extends ValidationException {

    private UnexpectedExceptionDuringValidationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UnexpectedExceptionDuringValidationException(Throwable cause) {
        super(cause);
    }

}

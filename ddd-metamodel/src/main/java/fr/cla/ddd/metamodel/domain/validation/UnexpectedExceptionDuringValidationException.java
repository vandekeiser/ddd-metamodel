package fr.cla.ddd.metamodel.domain.validation;

public class UnexpectedExceptionDuringValidationException extends AbstractValidationException {

    private UnexpectedExceptionDuringValidationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UnexpectedExceptionDuringValidationException(Throwable cause) {
        super(cause);
    }

}

package fr.cla.ddd.metamodel.domain.validation;

public abstract class AbstractValidationException extends IllegalArgumentException {

    protected AbstractValidationException(String msg) {
        super(msg);
    }

    protected AbstractValidationException(Throwable cause) {
        super(cause);
    }

    protected AbstractValidationException(String msg, Throwable cause) {
        super(msg, cause);
    }

}

package fr.cla.ddd.metamodel;

public abstract class ValidationException extends IllegalArgumentException {

    protected ValidationException(String msg) {
        super(msg);
    }

    protected ValidationException(Throwable cause) {
        super(cause);
    }

    protected ValidationException(String msg, Throwable cause) {
        super(msg, cause);
    }

}

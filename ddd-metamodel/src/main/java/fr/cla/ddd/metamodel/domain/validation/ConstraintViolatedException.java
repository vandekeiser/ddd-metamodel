package fr.cla.ddd.metamodel.domain.validation;

public class ConstraintViolatedException extends AbstractValidationException {

    public ConstraintViolatedException(String msg) {
        super(msg);
    }

}

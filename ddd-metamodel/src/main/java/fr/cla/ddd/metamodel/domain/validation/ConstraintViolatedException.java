package fr.cla.ddd.metamodel.domain.validation;

import fr.cla.ddd.metamodel.ValidationException;

public class ConstraintViolatedException extends ValidationException {

    public ConstraintViolatedException(String msg) {
        super(msg);
    }

}

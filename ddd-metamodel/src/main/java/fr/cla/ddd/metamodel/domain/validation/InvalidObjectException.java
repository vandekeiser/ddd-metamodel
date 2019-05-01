package fr.cla.ddd.metamodel.domain.validation;

import fr.cla.ddd.metamodel.ValidationException;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InvalidObjectException extends ValidationException {

    private final Object invalidObject;

    public InvalidObjectException(Object invalidObject) {
        super("Invalid object", null);
        this.invalidObject = invalidObject;
    }

    public Object getInvalidObject() {
        return invalidObject;
    }

    @Override
    public String toString() {
        if(invalidObject ==null) {
            return getMessage();
        } else {
            return String.format(
                "{invalidObject: %s, message: %s}",
                invalidObject, getMessage()
            );
        }
    }

    public final ValidationException[] getSuppressedValidationException() {
        return Stream.of(super.getSuppressed())
            //In case someone else called addSuppressd
            .filter(ValidationException.class::isInstance)
            .map(ValidationException.class::cast)
            .collect(toList())
            .toArray(new ValidationException[0])
        ;
    }

}

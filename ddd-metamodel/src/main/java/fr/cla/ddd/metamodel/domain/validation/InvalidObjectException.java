package fr.cla.ddd.metamodel.domain.validation;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InvalidObjectException extends AbstractValidationException {

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

    public final AbstractValidationException[] getSuppressedValidationException() {
        return Stream.of(super.getSuppressed())
            //In case someone else called addSuppressd
            .filter(AbstractValidationException.class::isInstance)
            .map(AbstractValidationException.class::cast)
            .collect(toList())
            .toArray(new AbstractValidationException[0])
        ;
    }

}

package fr.cla.ddd.metamodel.domain.validation;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ValidationException extends IllegalArgumentException {

    private final Object invalidObject;

    private ValidationException(String msg, Throwable cause, Object invalidObject) {
        super(msg, cause);
        this.invalidObject = invalidObject;
    }

    public static ValidationException invalidObject(Object invalid) {
        return new ValidationException("Invalid object", null, invalid);
    }

    public static ValidationException invalidPredicate(String msg) {
        return new ValidationException(msg, null, null);
    }

    public static ValidationException unexpectedExceptionDuringValidation(RuntimeException e) {
        return new ValidationException(e.getMessage(), e, null);
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

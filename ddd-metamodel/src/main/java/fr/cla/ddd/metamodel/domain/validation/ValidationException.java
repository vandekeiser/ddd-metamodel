package fr.cla.ddd.metamodel.domain.validation;

public class ValidationException extends IllegalArgumentException {

    private final Object invalid;

    private ValidationException(Object invalid, String msg) {
        super(msg);
        this.invalid = invalid;
    }

    public static ValidationException invalidObject(Object invalid) {
        return new ValidationException(invalid, "Invalid object");
    }

    public static ValidationException invalidPredicate(String msg) {
        return new ValidationException(null, msg);
    }

    public Object getInvalid() {
        return invalid;
    }

    @Override
    public String toString() {
        if(invalid==null) {
            return getMessage();
        } else {
            return String.format(
                "{invalid: %s, message: %s}",
                invalid, getMessage()
            );
        }
    }

}

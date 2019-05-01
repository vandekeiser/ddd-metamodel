package fr.cla.ddd.metamodel.domain.validation;

public interface Validable<T> {

    default void validate() throws InvalidObjectException {
        Validation<T> v = validator().validate(asDeclaredType());
        v.get();
    }

    Validator<? super T> validator();

    T asDeclaredType();

}

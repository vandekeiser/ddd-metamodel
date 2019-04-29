package fr.cla.ddd.metamodel.validation;

public interface Validable<T> {

    default void validate() {
        Validation<T> v = validator().validate(asDeclaredType());
        v.get();
    }

    Validator<? super T> validator();

    T asDeclaredType();

}

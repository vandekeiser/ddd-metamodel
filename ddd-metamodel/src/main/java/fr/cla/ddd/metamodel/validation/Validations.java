package fr.cla.ddd.metamodel.validation;

public class Validations {

    public static boolean isPositive(int i) {
        return i >= 0;
    }

    public static boolean isNotNull(Object o) {
        return o != null;
    }
}

package fr.cla.ddd.metamodel.domain.validation;

import java.util.UUID;

public class Validations {

    public static boolean isPositive(int i) {
        return i >= 0;
    }

    public static boolean isNotNull(Object o) {
        return o != null;
    }

    public static boolean isUuid(String s) {
        try {
            UUID.fromString(s);
            return true;
        } catch (IllegalArgumentException notAUuid) {
            return false;
        }
    }

}

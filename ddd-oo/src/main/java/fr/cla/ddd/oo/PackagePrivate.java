package fr.cla.ddd.metamodel;

/**
 * Package-private class to check that I can do whitebox tests in JPMS.
 * (simplest solution I found is to split the maven project into main/test)
 */
class PackagePrivate {

    static String nameOfTheCaptain() {
        return "Du Guesclin";
    }

}

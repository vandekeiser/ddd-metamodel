package fr.cla.ddd.metamodel.domain;

/**
 * Package-private class to check that I can do whitebox tests in JPMS.
 * (simplest solution I found is to split the maven project into main/test)
 */
class PackagePrivateMetamodel {

    static String nameOfTheCaptain() {
        return "Du Guesclin";
    }

}

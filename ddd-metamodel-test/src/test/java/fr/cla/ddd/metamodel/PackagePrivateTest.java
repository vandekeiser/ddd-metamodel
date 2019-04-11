package fr.cla.ddd.metamodel;

import fr.cla.ddd.metamodel.unit.AbstractValueObjectTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Doing whitebox tests in JPMS is hard:
 * -Whitebox tests require module-patching. With module-patching, the test-specific dependencies get dragged into "requires" of the module-info __in main__ (some tools take another module-info/test in src/test but that is not standard yet).
 * -It's not possible to have both whitebox tests and module test-dependencies:
 *      -Can do whitebox tests: https://sormuras.github.io/blog/2018-09-11-testing-in-the-modular-world.html
 *      -But that doesn't work if you have test-dependencies (https://stackoverflow.com/questions/53477690/properly-implementing-java-modules-in-a-maven-build-with-inter-module-test-depen)
 *
 * -Some tests frameworks have split packages (junit quickcheck). Yes that is not test-specific, but it adds one more failure mode.
 *
 * The simplest solution I found, taking into account that I want to continue to (just like in java 8):
 * -have whitebox tests of package-private classes and methods
 * -have maven test test-dependencies to share test code
 * ,is to split the maven project into two, one for main and one for test.
 * This way the lib can be used in a modular way (except its test modules though)
 */
public class PackagePrivateTest {

    @Test
    public void should_not_fail_because_of_jpms() {
        assertThat(
            PackagePrivate.nameOfTheCaptain()
        ).isEqualTo("Du Guesclin");
    }

}

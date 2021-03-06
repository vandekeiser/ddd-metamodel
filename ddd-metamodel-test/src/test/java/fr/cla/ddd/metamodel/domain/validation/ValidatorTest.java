package fr.cla.ddd.metamodel.domain.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.IntPredicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;


public class ValidatorTest {

    private Validator<User> sut;

    @BeforeEach
    public void setupValidator() {
        sut = Validator.of(User.class)
            .validate(User::getName, Objects::nonNull, "name must not be null")
            .validate(User::getName, name -> !name.isEmpty(), "name must not be empty")
            .validate(User::getAge, inBetween(0, 150)::test, "age must be between 0 and 150")
        ;
    }

    @Test
    public void should_pass_valid_user() {
        //Given
        User validUser = new User("bob", 12);

        //And
        Validation<User> validation = sut.validate(validUser);

        //When
        User validatedUser = validation.get();

        //Then
    }

    @Test
    public void should_fail_invalid_user() {
        //Given
        User invalidUser = new User("", -12);

        //And
        Validation<User> validation = sut.validate(invalidUser);

        try {
            //When
            validation.get();
            fail("Should have failed invalid user" + invalidUser);
        } catch (InvalidObjectException expected) {
            //Then
            expected.printStackTrace();
            assertThat(expected.getMessage()).isEqualTo("Invalid object");

            //And
            assertThat(expected.getInvalidObject()).isEqualTo(invalidUser);

            //And
            Throwable[] validationErrors = expected.getSuppressed();
            assertThat(validationErrors.length).isEqualTo(2);

            //And
            Throwable invalidName = validationErrors[0];
            assertThat(invalidName.getMessage()).isEqualTo("name must not be empty");

            //And
            Throwable invalidAge = validationErrors[1];
            assertThat(invalidAge.getMessage()).isEqualTo("age must be between 0 and 150");
        }
    }



    class User {
        private final String name;
        private final int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }

        @Override public String toString() {
            return String.format("{name:%s, age:%d}", name, age);
        }
    }

    public static IntPredicate inBetween(int start, int end) {
        return value -> value > start && value < end;
    }

}

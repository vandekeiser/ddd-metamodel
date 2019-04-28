package fr.cla.ddd.metamodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.fail;


public class ValidatorTest {

    private Validator<User> sut;

    @BeforeEach
    public void setupValidator() {
        sut = Validator.of(User.class)
            .validate(User::getName, Objects::nonNull, "name is null")
            .validate(User::getName, name -> !name.isEmpty(), "name is empty")
            .validate(User::getAge, inBetween(0, 150)::test, "age is between 0 and 150")
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
        } catch (IllegalArgumentException expected) {
            //Then
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

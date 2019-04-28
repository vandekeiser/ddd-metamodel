package fr.cla.ddd.metamodel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.IntPredicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;


    public class ValidatorTest {

//    @BeforeEach
//    public void setupValidator()
//        sut =

    @Test//[WARNING]
// ValidatorTest.java:[37,6] class org.junit.jupiter.api.Test in module  is not exported
    public void should_pass_valid_user() {
        //Given
        User user = new User("bob", 12);

        //And
        Validator<User> sut = Validator.of(user)
            .validate(User::getName, Objects::nonNull, "name is null")
            .validate(User::getName, name -> !name.isEmpty(), "name is empty")
            //.validate(User::getAge, age -> age > 0 && age < 150, "age is between 0 and 150")
            .validate(User::getAge, inBetween(0, 150)::test, "age is between 0 and 150")
        ;

        //When-then
        //User user = new User("", -12);
        User validatedUser = sut.get();
    }

    @Test
    public void should_fail_invalid_user() {
        //Given
        User user = new User("", -12);

        //And
        Validator<User> sut = Validator.of(user)
            .validate(User::getName, Objects::nonNull, "name is null")
            .validate(User::getName, name -> !name.isEmpty(), "name is empty")
            //.validate(User::getAge, age -> age > 0 && age < 150, "age is between 0 and 150")
            .validate(User::getAge, inBetween(0, 150)::test, "age is between 0 and 150")
        ;

        //When
        try {
            sut.get();
            fail("Should have failed invalid user" + user);
        } catch (IllegalArgumentException expected) {
            //Then
        }
    }



    public class User {
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

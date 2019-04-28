package fr.cla.ddd.metamodel;

import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.appli.ScheduleConferenceCommand;
import fr.cla.ddd.metamodel.validation.Validation;
import fr.cla.ddd.metamodel.validation.Validations;
import fr.cla.ddd.metamodel.validation.Validator;
import fr.cla.ddd.metamodel.validation.ValidatorTest;
import fr.cla.ddd.oo.Equatable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@formatter:off
public class AbstractValueObjectTest {

    @Test
    public void should_not_get_classcast_when_calling_equals_on_different_types() {
        ValueObject1 vo1 = new ValueObject1("foo");
        ValueObject2 vo2 = new ValueObject2(33);
        assertThat(
            vo1.equals(vo2)//shouldn't throw ClassCastException
        ).isFalse();
    }

    @Test
    public void should_not_instantiate_invalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ValueObject3(-1);
        });

    }

    @DDD.ValueObject
    private static class ValueObject1 extends AbstractValueObject<ValueObject1> {
        private final String value;

        ValueObject1(String value) {
            super(ValueObject1.class);
            this.value = value;
        }

        @Override
        protected List<Object> equalityCriteria() {
            return singletonList(value);
        }

        @Override
        protected Validator<ValueObject1> validator() {
            return Validator.none();
        }
    }

    @DDD.ValueObject
    private static class ValueObject2 extends AbstractValueObject<ValueObject2> {
        private final long value;

        ValueObject2(long value) {
            super(ValueObject2.class);
            this.value = value;
        }

        @Override
        protected List<Object> equalityCriteria() {
            return singletonList(value);
        }

        @Override
        protected Validator<ValueObject2> validator() {
            return Validator.none();
        }
    }

    @DDD.ValueObject
    private static class ValueObject3 extends AbstractValueObject<ValueObject3> {
        private final int value;

        ValueObject3(int value) {
            super(ValueObject3.class);
            this.value = value;
            validate();
        }

        private void validate() {
            Validation<ValueObject3> v = validator().validate(getDeclaredType().cast(this));
            v.get();
        }

        @Override
        protected List<Object> equalityCriteria() {
            return singletonList(value);
        }

        public int getValue() {
            return value;
        }

        @Override
        protected Validator<ValueObject3> validator() {
            return Validator.of(ValueObject3.class).validate(
                ValueObject3::getValue, Validations::isPositive, "value must be positive")
            ;
        }
    }

}
//@formatter:on
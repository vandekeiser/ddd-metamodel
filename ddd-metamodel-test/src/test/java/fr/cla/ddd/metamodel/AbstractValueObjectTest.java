package fr.cla.ddd.metamodel;

import fr.cla.ddd.metamodel.domain.AbstractValueObject;
import fr.cla.ddd.metamodel.domain.DDD;
import fr.cla.ddd.metamodel.domain.validation.AbstractValidationException;
import fr.cla.ddd.metamodel.domain.validation.Validations;
import fr.cla.ddd.metamodel.domain.validation.Validator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
        assertThrows(AbstractValidationException.class, () ->
            new ValueObject3(-1)
        );

    }

    @DDD.ValueObject
    private static class ValueObject1 extends AbstractValueObject<ValueObject1> {
        private final String value;

        ValueObject1(String value) {
            super(ValueObject1.class);
            this.value = value;
            validate();
        }

        @Override
        protected List<Object> equalityCriteria() {
            return singletonList(value);
        }

        @Override
        public Validator<ValueObject1> validator() {
            return Validator.none();
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @DDD.ValueObject
    private static class ValueObject2 extends AbstractValueObject<ValueObject2> {
        private final long value;

        ValueObject2(long value) {
            super(ValueObject2.class);
            this.value = value;
            validate();
        }

        @Override
        protected List<Object> equalityCriteria() {
            return singletonList(value);
        }

        @Override
        public Validator<ValueObject2> validator() {
            return Validator.none();
        }

        @Override
        public String toString() {
            return String.valueOf(value);
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

        @Override
        protected List<Object> equalityCriteria() {
            return singletonList(value);
        }

        public int getValue() {
            return value;
        }

        @Override
        public Validator<ValueObject3> validator() {
            return Validator.of(ValueObject3.class).validate(
                ValueObject3::getValue, Validations::isPositive, "value must be positive")
            ;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

}

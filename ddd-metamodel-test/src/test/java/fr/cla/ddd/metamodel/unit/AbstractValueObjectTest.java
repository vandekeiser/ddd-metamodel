package fr.cla.ddd.metamodel.unit;

import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.oo.Equatable;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

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
        protected boolean canEqual(Equatable<?> that) {
            return that instanceof ValueObject1;
        }
    }

    @DDD.ValueObject
    private static class ValueObject2 extends AbstractValueObject<ValueObject1> {
        private final long value;

        ValueObject2(long value) {
            super(ValueObject1.class);
            this.value = value;
        }

        @Override
        protected List<Object> equalityCriteria() {
            return singletonList(value);
        }

        @Override
        protected boolean canEqual(Equatable<?> that) {
            return that instanceof ValueObject2;
        }
    }

}
//@formatter:on
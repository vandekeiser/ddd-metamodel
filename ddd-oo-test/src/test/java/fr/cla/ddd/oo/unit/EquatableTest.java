package fr.cla.ddd.oo.unit;

import fr.cla.ddd.oo.Equatable;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
public class EquatableTest {

    @Test
    public void should_not_get_classcast_when_calling_equals_on_different_types() {
        var vo1 = new Equatable1("foo");
        var vo2 = new Equatable2(33);
        assertThat(
            vo1.equals(vo2)//shouldn't throw ClassCastException
        ).isFalse();
    }

    private static class Equatable1 extends Equatable<Equatable1> {
        private final String value;

        Equatable1(String value) {
            super(Equatable1.class, Equatability.SAME_DECLARED_CLASS);
            this.value = value;
        }

        @Override
        protected List<Object> equalityCriteria() {
            return singletonList(value);
        }

    }

    private static class Equatable2 extends Equatable<Equatable2> {
        private final long value;

        Equatable2(long value) {
            super(Equatable2.class, Equatability.SAME_DECLARED_CLASS);
            this.value = value;
        }

        @Override
        protected List<Object> equalityCriteria() {
            return singletonList(value);
        }

    }

}
//@formatter:on
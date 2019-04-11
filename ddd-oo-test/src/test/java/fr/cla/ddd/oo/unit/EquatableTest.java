package fr.cla.ddd.oo.unit;

import fr.cla.ddd.oo.Equatable;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
public class EquatableTest {

    @Test
    public void should_not_get_classcast_when_calling_equals_on_different_types() {
        Equatable1 vo1 = new Equatable1("foo");
        Equatable2 vo2 = new Equatable2(33);
        assertThat(
            vo1.equals(vo2)//shouldn't throw ClassCastException
        ).isFalse();
    }

    private static class Equatable1 extends Equatable<Equatable1> {
        private final String value;

        Equatable1(String value) {
            super(Equatable1.class);
            this.value = value;
        }

        @Override
        protected List<Object> equalityCriteria() {
            return List.of(value);
        }

        @Override
        protected boolean canEqual(Equatable<?> that) {
            return that instanceof Equatable1;
        }
    }

    private static class Equatable2 extends Equatable<Equatable1> {
        private final long value;

        Equatable2(long value) {
            super(Equatable1.class);
            this.value = value;
        }

        @Override
        protected List<Object> equalityCriteria() {
            return List.of(value);
        }

        @Override
        protected boolean canEqual(Equatable<?> that) {
            return that instanceof Equatable2;
        }
    }

}
//@formatter:on
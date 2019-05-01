package fr.cla.ddd.metamodel;

import fr.cla.ddd.metamodel.domain.AbstractEntity;
import fr.cla.ddd.metamodel.domain.AbstractValueObject;
import fr.cla.ddd.metamodel.domain.EntityId;
import fr.cla.ddd.metamodel.domain.validation.Constraints;
import fr.cla.ddd.metamodel.domain.validation.InvalidObjectException;
import fr.cla.ddd.metamodel.domain.validation.Validator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AbstractEntityTest {

    @Test
    public void should_not_get_classcast_when_calling_equals_on_different_types() {
        Entity1 vo1 = new Entity1(new Entity1Id(randomUUID().toString()));
        Entity2 vo2 = new Entity2(new Entity2Id(randomUUID().toString()));
        assertThat(
            vo1.equals(vo2)//shouldn't throw ClassCastException
        ).isFalse();
    }

    @Test
    public void should_not_instantiate_with_invalid_value() {
        assertThrows(InvalidObjectException.class, () ->
            new Entity3(new Entity3Id(randomUUID().toString()), -1)
        );

    }

    @Test
    public void should_not_set_invalid_value() {
        Entity3 e3 = new Entity3(new Entity3Id(randomUUID().toString()), 0);

        assertThrows(InvalidObjectException.class, () ->
            e3.setValue(-1)
        );

    }

    @DDD.ValueObject
    private static class Entity1 extends AbstractEntity<Entity1, Entity1Id> {

        Entity1(Entity1Id id) {
            super(Entity1.class, id);
            validate();
        }

        @Override
        public Validator<? super Entity1> validator() {
            return Validator.none();
        }

    }

    @DDD.ValueObject
    private static class Entity2 extends AbstractEntity<Entity2, Entity2Id> {

        Entity2(Entity2Id id) {
            super(Entity2.class, id);
            validate();
        }

        @Override
        public Validator<Entity2> validator() {
            return Validator.none();
        }
    }

    @DDD.ValueObject
    private static class Entity3 extends AbstractEntity<Entity3, Entity3Id> {

        private int value;

        Entity3(Entity3Id id, int value) {
            super(Entity3.class, id);
            this.value = value;
            validate();
        }

        int getValue() {
            return value;
        }

        @Override
        public Validator<Entity3> validator() {
            return Validator.of(Entity3.class)
                .validate(Entity3::getValue, Constraints::isPositive, "value must be positive")
            ;
        }

        public void setValue(int value) {
            this.value = value;
            validate();
        }
    }


    @DDD.EntityId
    private static class Entity1Id extends AbstractValueObject<Entity1Id> implements EntityId {

        private final String value;

        Entity1Id(String value) {
            super(Entity1Id.class);
            this.value = value;
            validate();
        }

        String getValue() {
            return value;
        }

        @Override
        protected List<Object> equalityCriteria() {
            return singletonList(value);
        }

        @Override
        public Validator<Entity1Id> validator() {
            return Validator.of(Entity1Id.class)
                .validate(Entity1Id::getValue, Constraints::isNotNull, "value must not be null")
            ;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

    }

    @DDD.EntityId
    private static class Entity2Id extends AbstractValueObject<Entity2Id> implements EntityId {

        private final String value;

        Entity2Id(String value) {
            super(Entity2Id.class);
            this.value = value;
            validate();
        }

        String getValue() {
            return value;
        }

        @Override
        protected List<Object> equalityCriteria() {
            return singletonList(value);
        }

        @Override
        public Validator<Entity2Id> validator() {
            return Validator.of(Entity2Id.class)
                .validate(Entity2Id::getValue, Constraints::isNotNull, "value must not be null")
            ;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @DDD.EntityId
    private static class Entity3Id extends AbstractValueObject<Entity3Id> implements EntityId {

        private final String value;

        Entity3Id(String value) {
            super(Entity3Id.class);
            this.value = value;
            validate();
        }

        String getValue() {
            return value;
        }

        @Override
        protected List<Object> equalityCriteria() {
            return singletonList(value);
        }

        @Override
        public Validator<Entity3Id> validator() {
            return Validator.of(Entity3Id.class)
                .validate(Entity3Id::getValue, Constraints::isNotNull, "value must not be null")
            ;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

}

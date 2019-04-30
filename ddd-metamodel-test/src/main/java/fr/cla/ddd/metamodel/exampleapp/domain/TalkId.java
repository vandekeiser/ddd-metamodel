package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.EntityId;
import fr.cla.ddd.metamodel.validation.Validations;
import fr.cla.ddd.metamodel.validation.Validator;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.singletonList;


@DDD.ValueObjectId
public class TalkId extends AbstractValueObject<TalkId>
implements EntityId, Serializable {

    private final String value;

    public TalkId() {
        this(UUID.randomUUID().toString());
    }

    public TalkId(String value) {
        super(TalkId.class);
        this.value = value;
        validate();
    }

    public String getValue() {
        return value;
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(value);
    }

    @Override
    public Validator<TalkId> validator() {
        return Validator.of(TalkId.class)
            .validate(TalkId::getValue, Validations::isNotNull, "value must not be null")
            .validate(TalkId::getValue, Validations::isUuid, "value must be a Uuid")
        ;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}

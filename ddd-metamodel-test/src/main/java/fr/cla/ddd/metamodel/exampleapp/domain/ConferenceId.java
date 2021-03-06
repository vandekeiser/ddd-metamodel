package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.domain.AbstractValueObject;
import fr.cla.ddd.metamodel.domain.EntityId;
import fr.cla.ddd.metamodel.domain.validation.Constraints;
import fr.cla.ddd.metamodel.domain.validation.InvalidObjectException;
import fr.cla.ddd.metamodel.domain.validation.Validator;

import java.io.Serializable;
import java.util.List;

import static java.util.Collections.singletonList;
import static java.util.UUID.randomUUID;


@DDD.EntityId
public class ConferenceId extends AbstractValueObject<ConferenceId>
implements EntityId, Serializable {

    private final String value;

    public ConferenceId() {
        this(randomUUID().toString());
    }

    public ConferenceId(String value) throws InvalidObjectException {
        super(ConferenceId.class);
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
    public Validator<ConferenceId> validator() {
        return Validator.of(ConferenceId.class)
            .validate(ConferenceId::getValue, Constraints::isNotNull, "value must not be null")
            .validate(ConferenceId::getValue, Constraints::isUuid, "value must be a Uuid")
        ;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}

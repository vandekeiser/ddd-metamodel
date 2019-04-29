package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.EntityId;
import fr.cla.ddd.metamodel.validation.Validator;

import java.io.Serializable;
import java.util.List;

import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;
import static java.util.UUID.randomUUID;


@DDD.ValueObjectId
public class ConferenceId extends AbstractValueObject<ConferenceId>
implements EntityId, Serializable {

    private final String value;

    public ConferenceId(String value) {
        super(ConferenceId.class);
        this.value = requireNonNull(value);
    }

    public ConferenceId() {
        this(randomUUID().toString());
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(value);
    }

    @Override
    public Validator<ConferenceId> validator() {
        return Validator.none();
    }

}

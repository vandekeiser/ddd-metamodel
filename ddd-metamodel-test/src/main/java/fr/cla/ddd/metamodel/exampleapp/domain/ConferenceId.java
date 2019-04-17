package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.EntityId;

import java.util.List;

import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;
import static java.util.UUID.randomUUID;

//@formatter:off
@DDD.ValueObjectId
public class ConferenceId extends AbstractValueObject<ConferenceId>
implements EntityId {

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

}
//@formatter:on
package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.EntityId;
import fr.cla.ddd.metamodel.Main;
import fr.cla.ddd.metamodel.validation.Validator;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;


@DDD.ValueObjectId
public class TalkId extends AbstractValueObject<TalkId>
implements EntityId, Serializable {

    private final String value;

    public TalkId() {
        this(UUID.randomUUID().toString());
    }

    public TalkId(String value) {
        super(TalkId.class);
        this.value = requireNonNull(value);
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(value);
    }

    @Override
    public Validator<TalkId> validator() {
        return Validator.none();
    }

}

package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.EntityId;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;

//@formatter:off
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

}
//@formatter:on
package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.AbstractEntity;
import fr.cla.ddd.metamodel.DDD;

import static java.util.Objects.requireNonNull;

//@formatter:off
@DDD.Entity
public class Talk extends AbstractEntity<Talk, TalkId> {

    private MonetaryAmount cost;

    public Talk(MonetaryAmount cost) {
        this(new TalkId(), cost);
    }

    public Talk(TalkId id, MonetaryAmount cost) {
        super(Talk.class, id);
        this.cost = requireNonNull(cost);
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    private Talk() {
        super(Talk.class);
        this.cost = null;
    }
}
//@formatter:on
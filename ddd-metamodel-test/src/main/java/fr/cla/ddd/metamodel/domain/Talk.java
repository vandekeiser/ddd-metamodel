package fr.cla.ddd.metamodel.domain;

import fr.cla.ddd.metamodel.AbstractEntity;
import fr.cla.ddd.metamodel.DDD;

import java.util.List;

import static java.util.Collections.singletonList;
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
}
//@formatter:on
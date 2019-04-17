package fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass;

import fr.cla.ddd.metamodel.AbstractEntity;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.TalkId;

import static java.util.Objects.requireNonNull;

//@formatter:off
@DDD.Entity
public class SrcTalk extends AbstractEntity<SrcTalk, TalkId> {

    private MonetaryAmount cost;

    public SrcTalk(MonetaryAmount cost) {
        this(new TalkId(), cost);
    }

    public SrcTalk(TalkId id, MonetaryAmount cost) {
        super(SrcTalk.class, id, Equatability.SAME_RUNTIME_CLASS);
        this.cost = requireNonNull(cost);
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    private SrcTalk() {
        super(SrcTalk.class, Equatability.SAME_RUNTIME_CLASS);
        this.cost = null;
    }
}
//@formatter:on
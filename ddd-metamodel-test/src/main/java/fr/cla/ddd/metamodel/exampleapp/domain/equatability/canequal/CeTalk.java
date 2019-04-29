package fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal;

import fr.cla.ddd.metamodel.AbstractEntity;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.TalkId;
import fr.cla.ddd.metamodel.validation.Validator;

import static java.util.Objects.requireNonNull;


@DDD.Entity
public class CeTalk extends AbstractEntity<CeTalk, TalkId> {

    private MonetaryAmount cost;

    public CeTalk(MonetaryAmount cost) {
        this(new TalkId(), cost);
    }

    public CeTalk(TalkId id, MonetaryAmount cost) {
        super(CeTalk.class, id, Equatability.CAN_EQUAL);
        this.cost = requireNonNull(cost);
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    private CeTalk() {
        super(CeTalk.class, Equatability.CAN_EQUAL);
        this.cost = null;
    }

    @Override
    public Validator<? super CeTalk> validator() {
        return Validator.none();
    }

}

package fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal;

import fr.cla.ddd.metamodel.domain.AbstractEntity;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.domain.validation.Validations;
import fr.cla.ddd.metamodel.domain.validation.Validator;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.TalkId;


@DDD.Entity
public class CeTalk extends AbstractEntity<CeTalk, TalkId> {

    private MonetaryAmount cost;

    public CeTalk(MonetaryAmount cost) {
        this(new TalkId(), cost);
    }

    public CeTalk(TalkId id, MonetaryAmount cost) {
        super(CeTalk.class, id, Equatability.CAN_EQUAL);
        this.cost = cost;
        validate();
    }

    public MonetaryAmount getCost() {
        return cost;
    }

    @Override
    public Validator<? super CeTalk> validator() {
        return Validator.of(CeTalk.class).validate(
            CeTalk::getCost, Validations::isNotNull, "cost must not be null")
        ;
    }

    @Override
    public String toString() {
        return String.format(
            "%s{cost: %s}",
            getClass().getSimpleName(), cost
        );
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    private CeTalk() {
        super(CeTalk.class, Equatability.CAN_EQUAL);
        this.cost = null;
    }

}

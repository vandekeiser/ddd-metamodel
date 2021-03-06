package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredtype;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.domain.AbstractEntity;
import fr.cla.ddd.metamodel.domain.validation.Constraints;
import fr.cla.ddd.metamodel.domain.validation.InvalidObjectException;
import fr.cla.ddd.metamodel.domain.validation.Validator;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.TalkId;

@DDD.Entity(aggregateRoot = SdtConference.class)
public class SdtTalk extends AbstractEntity<SdtTalk, TalkId> {

    private MonetaryAmount cost;

    public SdtTalk(MonetaryAmount cost) throws InvalidObjectException {
        this(new TalkId(), cost);
    }

    public SdtTalk(TalkId id, MonetaryAmount cost) throws InvalidObjectException {
        super(SdtTalk.class, id, Equatability.SAME_DECLARED_TYPE);
        this.cost = cost;
        validate();
    }

    public MonetaryAmount getCost() {
        return cost;
    }

    @Override
    public Validator<? super SdtTalk> validator() {
        return Validator.of(SdtTalk.class)
            .validate(SdtTalk::getCost, Constraints::isNotNull, "cost must not be null")
        ;
    }

    @Override
    public String toString() {
        return String.format(
            "%s{cost: %s}",
            getDeclaredType().getSimpleName(), cost
        );
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    private SdtTalk() {
        super(SdtTalk.class, Equatability.SAME_DECLARED_TYPE);
        this.cost = null;
    }

}

package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredtype;

import fr.cla.ddd.metamodel.domain.AbstractEntity;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.domain.validation.Validations;
import fr.cla.ddd.metamodel.domain.validation.Validator;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.TalkId;

@DDD.Entity
public class SdtTalk extends AbstractEntity<SdtTalk, TalkId> {

    private MonetaryAmount cost;

    public SdtTalk(MonetaryAmount cost) {
        this(new TalkId(), cost);
    }

    public SdtTalk(TalkId id, MonetaryAmount cost) {
        super(SdtTalk.class, id, Equatability.SAME_DECLARED_CLASS);
        this.cost = cost;
        validate();
    }

    public MonetaryAmount getCost() {
        return cost;
    }

    @Override
    public Validator<? super SdtTalk> validator() {
        return Validator.of(SdtTalk.class).validate(
            SdtTalk::getCost, Validations::isNotNull, "cost must not be null")
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
    private SdtTalk() {
        super(SdtTalk.class, Equatability.SAME_DECLARED_CLASS);
        this.cost = null;
    }

}

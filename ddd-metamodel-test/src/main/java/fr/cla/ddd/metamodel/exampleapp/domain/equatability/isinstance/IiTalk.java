package fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance;

import fr.cla.ddd.metamodel.AbstractEntity;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.TalkId;
import fr.cla.ddd.metamodel.validation.Validations;
import fr.cla.ddd.metamodel.validation.Validator;

@DDD.Entity
public class IiTalk extends AbstractEntity<IiTalk, TalkId> {

    private MonetaryAmount cost;

    public IiTalk(MonetaryAmount cost) {
        this(new TalkId(), cost);
    }

    public IiTalk(TalkId id, MonetaryAmount cost) {
        super(IiTalk.class, id, Equatability.IS_INSTANCE);
        this.cost = cost;
        validate();
    }

    public MonetaryAmount getCost() {
        return cost;
    }

    @Override
    public Validator<? super IiTalk> validator() {
        return Validator.of(IiTalk.class).validate(
            IiTalk::getCost, Validations::isNotNull, "cost must not be null")
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
    private IiTalk() {
        super(IiTalk.class, Equatability.IS_INSTANCE);
        this.cost = null;
    }

}

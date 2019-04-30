package fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype;

import fr.cla.ddd.metamodel.domain.AbstractEntity;
import fr.cla.ddd.metamodel.domain.DDD;
import fr.cla.ddd.metamodel.domain.validation.Validations;
import fr.cla.ddd.metamodel.domain.validation.Validator;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.TalkId;

@DDD.Entity
public class SrtTalk extends AbstractEntity<SrtTalk, TalkId> {

    private MonetaryAmount cost;

    public SrtTalk(MonetaryAmount cost) {
        this(new TalkId(), cost);
    }

    public SrtTalk(TalkId id, MonetaryAmount cost) {
        super(SrtTalk.class, id, Equatability.SAME_RUNTIME_CLASS);
        this.cost = cost;
        validate();
    }

    public MonetaryAmount getCost() {
        return cost;
    }

    @Override
    public Validator<? super SrtTalk> validator() {
        return Validator.of(SrtTalk.class).validate(
            SrtTalk::getCost, Validations::isNotNull, "cost must not be null")
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
    private SrtTalk() {
        super(SrtTalk.class, Equatability.SAME_RUNTIME_CLASS);
        this.cost = null;
    }

}

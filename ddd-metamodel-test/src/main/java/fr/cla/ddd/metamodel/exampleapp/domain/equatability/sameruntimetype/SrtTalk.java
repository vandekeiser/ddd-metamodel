package fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.domain.AbstractEntity;
import fr.cla.ddd.metamodel.domain.validation.Constraints;
import fr.cla.ddd.metamodel.domain.validation.InvalidObjectException;
import fr.cla.ddd.metamodel.domain.validation.Validator;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.TalkId;

@DDD.Entity(aggregateRoot = SrtConference.class)
public class SrtTalk extends AbstractEntity<SrtTalk, TalkId> {

    private MonetaryAmount cost;

    public SrtTalk(MonetaryAmount cost) throws InvalidObjectException {
        this(new TalkId(), cost);
    }

    public SrtTalk(TalkId id, MonetaryAmount cost) throws InvalidObjectException {
        super(SrtTalk.class, id, Equatability.SAME_RUNTIME_TYPE);
        this.cost = cost;
        validate();
    }

    public MonetaryAmount getCost() {
        return cost;
    }

    @Override
    public Validator<? super SrtTalk> validator() {
        return Validator.of(SrtTalk.class)
            .validate(SrtTalk::getCost, Constraints::isNotNull, "cost must not be null")
        ;
    }

    @Override
    public String toString() {
        return String.format(
            "%s{cost: %s}",
            //Use getClass (instead of getDeclaredType) in toString as well to be coherent with Equatability.SAME_RUNTIME_TYPE
            getClass().getSimpleName(), cost
        );
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    private SrtTalk() {
        super(SrtTalk.class, Equatability.SAME_RUNTIME_TYPE);
        this.cost = null;
    }

}

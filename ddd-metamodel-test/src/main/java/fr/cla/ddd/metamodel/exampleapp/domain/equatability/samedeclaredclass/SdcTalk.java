package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredclass;

import fr.cla.ddd.metamodel.AbstractEntity;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.TalkId;
import fr.cla.ddd.metamodel.validation.Validator;

import static java.util.Objects.requireNonNull;


@DDD.Entity
public class SdcTalk extends AbstractEntity<SdcTalk, TalkId> {

    private MonetaryAmount cost;

    public SdcTalk(MonetaryAmount cost) {
        this(new TalkId(), cost);
    }

    public SdcTalk(TalkId id, MonetaryAmount cost) {
        super(SdcTalk.class, id, Equatability.SAME_DECLARED_CLASS);
        this.cost = requireNonNull(cost);
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    private SdcTalk() {
        super(SdcTalk.class, Equatability.SAME_DECLARED_CLASS);
        this.cost = null;
    }

    @Override
    public Validator<? super SdcTalk> validator() {
        return Validator.none();
    }

}

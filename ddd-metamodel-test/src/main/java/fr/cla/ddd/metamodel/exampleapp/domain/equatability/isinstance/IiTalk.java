package fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance;

import fr.cla.ddd.metamodel.AbstractEntity;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.TalkId;
import fr.cla.ddd.metamodel.validation.Validator;

import static java.util.Objects.requireNonNull;

//@formatter:off
@DDD.Entity
public class IiTalk extends AbstractEntity<IiTalk, TalkId> {

    private MonetaryAmount cost;

    public IiTalk(MonetaryAmount cost) {
        this(new TalkId(), cost);
    }

    public IiTalk(TalkId id, MonetaryAmount cost) {
        super(IiTalk.class, id, Equatability.IS_INSTANCE);
        this.cost = requireNonNull(cost);
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    private IiTalk() {
        super(IiTalk.class, Equatability.IS_INSTANCE);
        this.cost = null;
    }

    @Override
    public Validator<? super IiTalk> validator() {
        return Validator.none();
    }

}
//@formatter:on
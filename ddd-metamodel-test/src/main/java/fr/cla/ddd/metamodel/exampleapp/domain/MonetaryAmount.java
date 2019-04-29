package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.validation.Validator;

import java.util.List;

import static java.util.Collections.singletonList;


@DDD.ValueObject
public class MonetaryAmount extends AbstractValueObject<MonetaryAmount> {

    private final int amount;

    public MonetaryAmount(int amount) {
        super(MonetaryAmount.class);
        this.amount = amount; //TODO validate
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(amount);
    }

    @Override
    public Validator<MonetaryAmount> validator() {
        return Validator.none();
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    private MonetaryAmount() {
        super(MonetaryAmount.class);
        this.amount = 0;
    }

}

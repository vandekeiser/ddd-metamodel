package fr.cla.ddd.metamodel.domain;

import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.DDD;

import java.util.List;

import static java.util.Collections.singletonList;

//@formatter:off
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

}
//@formatter:on
package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredtype;

import fr.cla.ddd.metamodel.AbstractAggregateRoot;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.validation.Validations;
import fr.cla.ddd.metamodel.validation.Validator;

import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.emptySet;


@DDD.Entity
public class SdtConference extends AbstractAggregateRoot<SdtConference, ConferenceId> {

    private MonetaryAmount budget;
    private final Set<SdtTalk> talks = new HashSet<>();

    public SdtConference(ConferenceId id, MonetaryAmount budget) {
        this(id, budget, emptySet());
    }

    public SdtConference(ConferenceId id, MonetaryAmount budget, SdtTalk... talks) {
        this(id, budget, Set.of(talks));
    }

    public SdtConference(ConferenceId id, MonetaryAmount budget, Set<SdtTalk> talks) {
        super(SdtConference.class, id, Equatability.SAME_DECLARED_CLASS);
        this.budget = budget;
        this.talks.addAll(talks);
        validate();
    }

    public MonetaryAmount getBudget() {
        return budget;
    }

    public Set<SdtTalk> getTalks() {
        return new HashSet<>(talks);
    }

    @Override
    public Validator<? super SdtConference> validator() {
        return Validator.of(SdtConference.class)
            .validate(SdtConference::getBudget, Validations::isNotNull, "budget must not be null")
            .validate(SdtConference::totalCostDoesNotExceedBudget, "total cost must not exceed budget")
        ;
    }

    private boolean totalCostDoesNotExceedBudget() {
        return totalCost().isSmallerThanOrEqualTo(budget);
    }

    public MonetaryAmount totalCost() {
        return talks.stream().map(SdtTalk::getCost).collect(MonetaryAmount.summing());
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    SdtConference() { //TODO eqh: private KO! (without lazy proxies, private is fine)
        super(SdtConference.class, Equatability.SAME_DECLARED_CLASS);
        this.budget = null;
    }

}

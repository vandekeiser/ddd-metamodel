package fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype;

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
public class SrtConference extends AbstractAggregateRoot<SrtConference, ConferenceId> {

    private MonetaryAmount budget;
    private final Set<SrtTalk> talks = new HashSet<>();

    public SrtConference(ConferenceId id, MonetaryAmount budget) {
        this(id, budget, emptySet());
    }

    public SrtConference(ConferenceId id, MonetaryAmount budget, SrtTalk... talks) {
        this(id, budget, Set.of(talks));
    }

    public SrtConference(ConferenceId id, MonetaryAmount budget, Set<SrtTalk> talks) {
        super(SrtConference.class, id, Equatability.SAME_RUNTIME_CLASS);
        this.budget = budget;
        this.talks.addAll(talks);
        validate();
    }

    public MonetaryAmount getBudget() {
        return budget;
    }

    public Set<SrtTalk> getTalks() {
        return new HashSet<>(talks);
    }

    @Override
    public Validator<? super SrtConference> validator() {
        return Validator.of(SrtConference.class)
            .validate(SrtConference::getBudget, Validations::isNotNull, "budget must not be null")
            .validate(SrtConference::totalCostDoesNotExceedBudget, "total cost must not exceed budget")
            ;
    }

    private boolean totalCostDoesNotExceedBudget() {
        return totalCost().isSmallerThanOrEqualTo(budget);
    }

    public MonetaryAmount totalCost() {
        return talks.stream().map(SrtTalk::getCost).collect(MonetaryAmount.summing());
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    SrtConference() { //TODO eqh: private KO! (without lazy proxies, private is fine)
        super(SrtConference.class, Equatability.SAME_RUNTIME_CLASS);
        this.budget = null;
    }

}

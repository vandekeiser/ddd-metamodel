package fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance;

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
public class IiConference extends AbstractAggregateRoot<IiConference, ConferenceId> {

    private MonetaryAmount budget;
    private final Set<IiTalk> talks = new HashSet<>();

    public IiConference(ConferenceId id, MonetaryAmount budget) {
        this(id, budget, emptySet());
    }

    public IiConference(ConferenceId id, MonetaryAmount budget, IiTalk... talks) {
        this(id, budget, Set.of(talks));
    }

    public IiConference(ConferenceId id, MonetaryAmount budget, Set<IiTalk> talks) {
        super(IiConference.class, id, Equatability.IS_INSTANCE);
        this.budget = budget;
        this.talks.addAll(talks);
        validate();
    }

    public MonetaryAmount getBudget() {
        return budget;
    }

    public Set<IiTalk> getTalks() {
        return new HashSet<>(talks);
    }

    @Override
    public Validator<? super IiConference> validator() {
        return Validator.of(IiConference.class)
            .validate(IiConference::getBudget, Validations::isNotNull, "budget must not be null")
            .validate(IiConference::totalCostDoesNotExceedBudget, "total cost must not exceed budget")
        ;
    }

    private boolean totalCostDoesNotExceedBudget() {
        return totalCost().isSmallerThanOrEqualTo(budget);
    }

    public MonetaryAmount totalCost() {
        return talks.stream().map(IiTalk::getCost).collect(MonetaryAmount.summing());
    }

    @Override
    public String toString() {
        return String.format(
            "%s{id: %s, version: %s, budget: %s, talks: %s}",
            getClass().getSimpleName(), getId(), getVersion(), getBudget(), getTalks()
        );
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    IiConference() { //TODO eqh: private KO! (without lazy proxies, private is fine)
        super(IiConference.class, Equatability.IS_INSTANCE);
        this.budget = null;
    }

}

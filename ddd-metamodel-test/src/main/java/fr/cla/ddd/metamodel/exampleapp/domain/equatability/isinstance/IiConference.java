package fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.domain.AbstractAggregateRoot;
import fr.cla.ddd.metamodel.domain.validation.Constraints;
import fr.cla.ddd.metamodel.domain.validation.InvalidObjectException;
import fr.cla.ddd.metamodel.domain.validation.Validator;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;

import java.util.Set;

import static java.util.Collections.emptySet;


@DDD.AggregateRoot
public class IiConference extends AbstractAggregateRoot<IiConference, ConferenceId> {

    private MonetaryAmount budget;
    private final Set<IiTalk> talks;

    public IiConference(ConferenceId id, MonetaryAmount budget) throws InvalidObjectException {
        this(id, budget, emptySet());
    }

    public IiConference(ConferenceId id, MonetaryAmount budget, IiTalk... talks) throws InvalidObjectException {
        this(id, budget, Set.of(talks));
    }

    public IiConference(ConferenceId id, MonetaryAmount budget, Set<IiTalk> talks) throws InvalidObjectException {
        super(IiConference.class, id, Equatability.IS_INSTANCE);
        this.budget = budget;
        this.talks = defensiveCopy(talks);
        validate();
    }

    public MonetaryAmount getBudget() {
        return budget;
    }

    public Set<IiTalk> getTalks() {
        return defensiveCopy(talks);
    }

    @Override
    public Validator<? super IiConference> validator() {
        return Validator.of(IiConference.class)
            .validate(IiConference::getBudget, Constraints::isNotNull, "budget must not be null")
            .validate(IiConference::getTalks, Constraints::isNotNull, "talks must not be null")
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
            getDeclaredType().getSimpleName(), getId(), getVersion(), getBudget(), getTalks()
        );
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    IiConference() { //TODO eqh: private KO! (without lazy proxies, private is fine)
        super(IiConference.class, Equatability.IS_INSTANCE);
        this.budget = null;
        this.talks = null;
    }

}

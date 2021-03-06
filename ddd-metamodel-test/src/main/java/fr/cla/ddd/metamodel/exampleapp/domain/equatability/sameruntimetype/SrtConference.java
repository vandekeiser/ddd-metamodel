package fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype;

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
public class SrtConference extends AbstractAggregateRoot<SrtConference, ConferenceId> {

    private MonetaryAmount budget;
    private final Set<SrtTalk> talks;

    public SrtConference(ConferenceId id, MonetaryAmount budget) throws InvalidObjectException {
        this(id, budget, emptySet());
    }

    public SrtConference(ConferenceId id, MonetaryAmount budget, SrtTalk... talks) throws InvalidObjectException {
        this(id, budget, Set.of(talks));
    }

    public SrtConference(ConferenceId id, MonetaryAmount budget, Set<SrtTalk> talks) throws InvalidObjectException {
        super(SrtConference.class, id, Equatability.SAME_RUNTIME_TYPE);
        this.budget = budget;
        this.talks = defensiveCopy(talks);
        validate();
    }

    public MonetaryAmount getBudget() {
        return budget;
    }

    public Set<SrtTalk> getTalks() {
        return defensiveCopy(talks);
    }

    @Override
    public Validator<? super SrtConference> validator() {
        return Validator.of(SrtConference.class)
            .validate(SrtConference::getBudget, Constraints::isNotNull, "budget must not be null")
            .validate(SrtConference::getTalks, Constraints::isNotNull, "talks must not be null")
            .validate(SrtConference::totalCostDoesNotExceedBudget, "total cost must not exceed budget")
        ;
    }

    private boolean totalCostDoesNotExceedBudget() {
        return totalCost().isSmallerThanOrEqualTo(budget);
    }

    public MonetaryAmount totalCost() {
        return talks.stream().map(SrtTalk::getCost).collect(MonetaryAmount.summing());
    }

    @Override
    public String toString() {
        return String.format(
            "%s{id: %s, version: %s, budget: %s, talks: %s}",
            //Use getClass (instead of getDeclaredType) in toString as well to be coherent with Equatability.SAME_RUNTIME_TYPE
            getClass().getSimpleName(), getId(), getVersion(), getBudget(), getTalks()
        );
    }


    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    SrtConference() { //TODO eqh: private KO! (without lazy proxies, private is fine)
        super(SrtConference.class, Equatability.SAME_RUNTIME_TYPE);
        this.budget = null;
        this.talks = null;
    }

}

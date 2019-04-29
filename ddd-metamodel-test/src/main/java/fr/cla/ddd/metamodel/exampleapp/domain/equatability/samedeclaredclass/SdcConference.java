package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredclass;

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
public class SdcConference extends AbstractAggregateRoot<SdcConference, ConferenceId> {

    private MonetaryAmount budget;
    private final Set<SdcTalk> talks = new HashSet<>();

    public SdcConference(ConferenceId id, MonetaryAmount budget) {
        this(id, budget, emptySet());
    }

    public SdcConference(ConferenceId id, MonetaryAmount budget, SdcTalk... talks) {
        this(id, budget, Set.of(talks));
    }

    public SdcConference(ConferenceId id, MonetaryAmount budget, Set<SdcTalk> talks) {
        super(SdcConference.class, id, Equatability.SAME_DECLARED_CLASS);
        this.budget = budget;
        this.talks.addAll(talks);
        validate();
    }

    public MonetaryAmount getBudget() {
        return budget;
    }

    public Set<SdcTalk> getTalks() {
        return new HashSet<>(talks);
    }

    @Override
    public Validator<? super SdcConference> validator() {
        return Validator.of(SdcConference.class).validate(
            SdcConference::getBudget, Validations::isNotNull, "budget must not be null")
        ;
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    SdcConference() { //TODO eqh: private KO! (without lazy proxies, private is fine)
        super(SdcConference.class, Equatability.SAME_DECLARED_CLASS);
        this.budget = null;
    }

}

package fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass;

import fr.cla.ddd.metamodel.AbstractAggregateRoot;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.validation.Validator;

import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.emptySet;
import static java.util.Objects.requireNonNull;


@DDD.Entity
public class SrcConference extends AbstractAggregateRoot<SrcConference, ConferenceId> {

    private MonetaryAmount budget;
    private final Set<SrcTalk> talks = new HashSet<>();

    public SrcConference(ConferenceId id, MonetaryAmount budget) {
        this(id, budget, emptySet());
    }

    public SrcConference(ConferenceId id, MonetaryAmount budget, SrcTalk... talks) {
        this(id, budget, Set.of(talks));
    }

    public SrcConference(ConferenceId id, MonetaryAmount budget, Set<SrcTalk> talks) {
        super(SrcConference.class, id, Equatability.SAME_RUNTIME_CLASS);
        this.budget = requireNonNull(budget);
        this.talks.addAll(talks);
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    SrcConference() { //TODO eqh: private KO! (without lazy proxies, private is fine)
        super(SrcConference.class, Equatability.SAME_RUNTIME_CLASS);
        this.budget = null;
    }

    public Set<SrcTalk> getTalks() {
        return new HashSet<>(talks);
    }

    @Override
    public Validator<? super SrcConference> validator() {
        return Validator.none();
    }

}

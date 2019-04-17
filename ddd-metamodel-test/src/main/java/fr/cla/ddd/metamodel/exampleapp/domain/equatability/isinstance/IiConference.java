package fr.cla.ddd.metamodel.exampleapp.domain.equatability.isinstance;

import fr.cla.ddd.metamodel.AbstractAggregateRoot;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;

import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.emptySet;
import static java.util.Objects.requireNonNull;

//@formatter:off
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
        super(IiConference.class, id, Equatability.SAME_DECLARED_CLASS);
        this.budget = requireNonNull(budget);
        this.talks.addAll(talks);
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    IiConference() { //TODO eqh: private KO!
        super(IiConference.class, Equatability.SAME_DECLARED_CLASS);
        this.budget = null;
    }

    public Set<IiTalk> getTalks() {
        return new HashSet<>(talks);
    }
}
//@formatter:on
package fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal;

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
public class CeConference extends AbstractAggregateRoot<CeConference, ConferenceId> {

    private MonetaryAmount budget;
    private final Set<CeTalk> talks = new HashSet<>();

    public CeConference(ConferenceId id, MonetaryAmount budget) {
        this(id, budget, emptySet());
    }

    public CeConference(ConferenceId id, MonetaryAmount budget, CeTalk... talks) {
        this(id, budget, Set.of(talks));
    }

    public CeConference(ConferenceId id, MonetaryAmount budget, Set<CeTalk> talks) {
        super(CeConference.class, id, Equatability.CAN_EQUAL);
        this.budget = requireNonNull(budget);
        this.talks.addAll(talks);
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    CeConference() { //TODO eqh: private KO!
        super(CeConference.class, Equatability.CAN_EQUAL);
        this.budget = null;
    }

    public Set<CeTalk> getTalks() {
        return new HashSet<>(talks);
    }
}
//@formatter:on
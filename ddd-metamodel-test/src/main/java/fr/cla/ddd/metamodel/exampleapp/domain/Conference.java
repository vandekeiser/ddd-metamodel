package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.AbstractAggregateRoot;
import fr.cla.ddd.metamodel.AbstractEntity;
import fr.cla.ddd.metamodel.DDD;

import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.emptySet;
import static java.util.Objects.requireNonNull;

//@formatter:off
@DDD.Entity
public class Conference extends AbstractAggregateRoot<Conference, ConferenceId> {

    private MonetaryAmount budget;
    private final Set<Talk> talks = new HashSet<>();

    public Conference(ConferenceId id, MonetaryAmount budget) {
        this(id, budget, emptySet());
    }

    public Conference(ConferenceId id, MonetaryAmount budget, Talk... talks) {
        this(id, budget, Set.of(talks));
    }

    public Conference(ConferenceId id, MonetaryAmount budget, Set<Talk> talks) {
        super(Conference.class, id);
        this.budget = requireNonNull(budget);
        this.talks.addAll(talks);
    }

}
//@formatter:on
package fr.cla.ddd.metamodel.exampleapp.domain.equatability.samedeclaredclass;

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
        this.budget = requireNonNull(budget);
        this.talks.addAll(talks);
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    SdcConference() { //TODO eqh: private KO! (without lazy proxies, private is fine)
        super(SdcConference.class, Equatability.SAME_DECLARED_CLASS);
        this.budget = null;
    }

    public Set<SdcTalk> getTalks() {
        return new HashSet<>(talks);
    }
}
//@formatter:on
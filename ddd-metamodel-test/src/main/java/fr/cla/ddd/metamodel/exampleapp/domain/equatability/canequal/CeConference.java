package fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal;

import fr.cla.ddd.metamodel.AbstractAggregateRoot;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.validation.Validator;

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
//    TODO eqh: private constructor KO with lazy proxies (without lazy proxies, private is fine),
//     really needs to be at least package-private?
//    22:59:44.183 [main] ERROR o.h.p.p.b.ByteBuddyProxyFactory - HHH000142: Bytecode enhancement failed: fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal.CeConference
//    java.lang.InstantiationException: fr.cla.ddd.metamodel.exampleapp.domain.equatability.canequal.CeConference$HibernateProxy$TqkQwN9R
//    at java.base/java.lang.Class.newInstance(Class.java:571)
//    at org.hibernate.proxy.pojo.bytebuddy.ByteBuddyProxyFactory.getProxy(ByteBuddyProxyFactory.java:90)
//    at org.hibernate.tuple.entity.AbstractEntityTuplizer.createProxy(AbstractEntityTuplizer.java:701)
//    at org.springframework.data.jpa.repository.support.SimpleJpaRepository.getOne(SimpleJpaRepository.java:255)
//    at fr.cla.ddd.metamodel.exampleapp.infra.equatability.canequal.SdjCeConferencesTest.loadLazyProxyFor(SdjCeConferencesTest.java:48)
//    at fr.cla.ddd.metamodel.exampleapp.infra.equatability.canequal.SdjCeConferencesTest.loadLazyProxyFor(SdjCeConferencesTest.java:16)
//    at fr.cla.ddd.metamodel.exampleapp.infra.equatability.AbstractSdjConferencesTest.loadLazyProxy(AbstractSdjConferencesTest.java:120)
//    at fr.cla.ddd.metamodel.exampleapp.infra.equatability.AbstractSdjConferencesTest.lambda$reloaded_lazy_proxy_should_be_equal$0(AbstractSdjConferencesTest.java:98)
//    at fr.cla.ddd.metamodel.exampleapp.infra.equatability.AbstractSdjConferencesTest.doInAnotherTransaction(AbstractSdjConferencesTest.java:138)
//    at fr.cla.ddd.metamodel.exampleapp.infra.equatability.AbstractSdjConferencesTest.reloaded_lazy_proxy_should_be_equal(AbstractSdjConferencesTest.java:94)
//    at fr.cla.ddd.metamodel.exampleapp.infra.equatability.AbstractSdjConferencesTest.reloaded_lazy_proxy_should_be_equal(AbstractSdjConferencesTest.java:81)
    CeConference() {
        super(CeConference.class, Equatability.CAN_EQUAL);
        this.budget = null;
    }

    public Set<CeTalk> getTalks() {
        return new HashSet<>(talks);
    }

    @Override
    public Validator<? super CeConference> validator() {
        return Validator.none();
    }

}
//@formatter:on
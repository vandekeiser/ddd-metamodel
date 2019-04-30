package fr.cla.ddd.metamodel.domain;

import fr.cla.ddd.metamodel.domain.validation.Validable;
import fr.cla.ddd.oo.Equatable;

import java.util.List;

import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;


/**
 * A DDD Entity: mutable object with a stable identity (doesn't change after construction).
 * Compared to Equatable, it also adds to the contract that the id is the only equality criterion,
 * and that the id is not null.
 */
@DDD.Entity
public abstract class AbstractEntity<
    T extends AbstractEntity<T, I>,
    I extends EntityId
>
extends Equatable<T>
implements Validable<T> {

    private final I id;

    protected AbstractEntity(Class<T> type, I id) {
        super(type);
        this.id = requireNonNull(id);
    }

    protected AbstractEntity(Class<T> type, I id, Equatability equatability) {
        super(type, equatability);
        this.id = requireNonNull(id);
    }

    protected final List<Object> equalityCriteria() {
//        TODO eqh: this doesn't work with JPA proxies as is, id will be null, ex:
//[ERROR] Failures:
//[ERROR]   SdjCeConferencesTest>AbstractSdjConferencesTest.reloaded_lazy_proxy_should_be_equal:81
//    ->AbstractSdjConferencesTest.reloaded_lazy_proxy_should_be_equal:94
//    ->AbstractSdjConferencesTest.doInAnotherTransaction:143
//    java.lang.AssertionError:
//    Expecting:
//        <"CeConference{[ConferenceId{[00fe0906-47e9-4999-b529-4eb87b11354d]}]} (CeConference$HibernateProxy$m9713TWc@3e)">
//    to be equal to:
//        <"CeConference{[ConferenceId{[00fe0906-47e9-4999-b529-4eb87b11354d]}]} (CeConference@5909f782)">
//    but was not.
        //TODO mieux préciser la cause de ce !eq
//        return singletonList(id);

        return singletonList(getId());
    }

//    TODO eqh: this doesn't work with JPA proxies as is, id will be null, ex:
//[ERROR] Failures:
//[ERROR]   SdjCeConferencesTest>AbstractSdjConferencesTest.reloaded_lazy_proxy_should_be_equal:81
//        ->AbstractSdjConferencesTest.reloaded_lazy_proxy_should_be_equal:94
//        ->AbstractSdjConferencesTest.doInAnotherTransaction:143
//    org.junit.ComparisonFailure:
//    expected:<ConferenceId{[3c230cb9-5219-40e5-9398-ca7c6a842a2d]}>
//    but was:<null>
//    public final I getId() {
    public I getId() {
        return id;
    }

    //Unfortunately this is required by JPA. Only use to declare the no-arg constructor.
    protected AbstractEntity(Class<T> type, Equatability equatability) {
        super(type, equatability);
        this.id = null;
    }

}


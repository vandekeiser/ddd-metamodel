package fr.cla.ddd.metamodel.exampleapp.infra;

import fr.cla.ddd.metamodel.domain.AbstractAggregateRoot;
import fr.cla.ddd.metamodel.domain.EntityId;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


public abstract class StubRepository<
    A extends AbstractAggregateRoot<A, I>,
    I extends EntityId
> {

    private final Map<I, A> store = new ConcurrentHashMap<>();

    public Optional<A> get(I id) {
        return Optional.ofNullable(store.get(id));
    }

    public void add(A aggregate) {
        store.put(aggregate.getId(), aggregate);
    }

}

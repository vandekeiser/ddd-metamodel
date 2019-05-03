package fr.cla.ddd.metamodel.domain;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


public abstract class FakeRepository<
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

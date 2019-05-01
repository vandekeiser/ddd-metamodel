package fr.cla.ddd.metamodel.domain;


import fr.cla.ddd.metamodel.DDD;

@DDD.AggregateRoot
public abstract class AbstractAggregateRoot<
    T extends AbstractAggregateRoot<T, I>,
    I extends EntityId
>
extends AbstractEntity<T, I> {

    private long version;

    protected AbstractAggregateRoot(Class<T> type, I id) {
        super(type, id);
    }

    protected AbstractAggregateRoot(Class<T> type, I id, Equatability equatability) {
        super(type, id, equatability);
    }

    public long getVersion() {
        return version;
    }

    //Unfortunately this is required by JPA. Only use to declare the no-arg constructor.
    protected AbstractAggregateRoot(Class<T> type, Equatability equatability) {
        super(type, equatability);
    }

}


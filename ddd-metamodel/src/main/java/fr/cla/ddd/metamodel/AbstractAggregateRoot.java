package fr.cla.ddd.metamodel;

//@formatter:off
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

}
//@formatter:on

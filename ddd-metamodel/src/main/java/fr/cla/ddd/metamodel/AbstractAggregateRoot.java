package fr.cla.ddd.metamodel;

//@formatter:off
@DDD.AggregateRoot
public abstract class AbstractAggregateRoot<
    T extends AbstractAggregateRoot<T, I, V>,
    I extends EntityId,
    V
>
extends AbstractEntity<T, I> {

    private V version;

    protected AbstractAggregateRoot(Class<T> type, I id) {
        super(type, id);
    }

    protected AbstractAggregateRoot(Class<T> type, I id, Equatability equatability) {
        super(type, id, equatability);
    }

}
//@formatter:on

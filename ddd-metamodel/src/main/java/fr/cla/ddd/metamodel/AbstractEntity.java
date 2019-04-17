package fr.cla.ddd.metamodel;

import fr.cla.ddd.oo.Equatable;

import java.util.List;

import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;

//@formatter:off
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
extends Equatable<T> {

    private final I id;

//    protected AbstractEntity(Class<T> type, I id) {
//        super(type);
//        this.id = requireNonNull(id);
//    }

    protected AbstractEntity(Class<T> type, I id, Equatability equatability) {
        super(type, equatability);
        this.id = requireNonNull(id);
    }

    protected final List<Object> equalityCriteria() {//TODO eqh: id KO!
        return singletonList(getId());
    }

    public /*final*/ I getId() {//TODO eqh: final KO!
        return id;
    }

    //Unfortunately this is required by JPA. Only use to declare the no-arg constructor.
    protected AbstractEntity(Class<T> type, Equatability equatability) {
        super(type, equatability);
        this.id = null;
    }

}
//@formatter:on

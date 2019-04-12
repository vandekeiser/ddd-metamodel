package fr.cla.ddd.metamodel;

//@formatter:off
import fr.cla.ddd.oo.Equatable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.*;
import static java.util.Objects.*;

/**
 * A DDD Entity: mutable object with a stable identity (doesn't change after construction).
 * Compared to Equatable, it also adds to the contract that the id is the only equality criterion,
 * and that the id is not null.
 */
public abstract class AbstractEntity<T extends AbstractEntity<T, I>, I extends EntityId>
extends Equatable<T> {

    private final I id;

    protected AbstractEntity(Class<T> type, I id) {
        super(type);
        this.id = requireNonNull(id);
    }

    protected AbstractEntity(Class<T> type, Equatability equatability, I id) {
        super(type, equatability);
        this.id = requireNonNull(id);
    }

    protected final List<Object> equalityCriteria() {
        return singletonList(id);
    }

    public final I getId() {
        return id;
    }

}
//@formatter:on

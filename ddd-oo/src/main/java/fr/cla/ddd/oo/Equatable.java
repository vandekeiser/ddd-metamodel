package fr.cla.ddd.oo;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;


/**
 * An abstract object that has an explicit policy of its instances being equal.
 */
public abstract class Equatable<T extends Equatable<T>> {

    private final Class<? extends T> type;
    private final Equatability equatability;

    protected Equatable(Class<? extends T> type) {
        this(type, Equatability.DEFAULT);
    }

    protected Equatable(Class<? extends T> type, Equatability equatability) {
        this.type = requireNonNull(type);
        this.equatability = requireNonNull(equatability);
    }

    @Override public final boolean equals(Object obj) {
        //An optimization, but also avoids StackOverflows on cyclic object graphs.
        if(obj == this) return true;

        //See javadoc of areEquatable
        if(! equatability.areEquatable(this, type, obj)) return false;

        Equatable<?> that = (Equatable<?>) obj;

        return Objects.equals(
            this.equalityCriteria(),
            that.equalityCriteria()
        );
    }

    @Override public final int hashCode() {
        return Objects.hash(
            equalityCriteria()
        );
    }

    @Override public String toString() {
        return String.format(
            "%s{%s}",
            getClass().getSimpleName(),
            equalityCriteria()
        );
    }

    protected abstract List<Object> equalityCriteria();

    public T asDeclaredType() {
        return type.cast(this);
    }

    /**
     * @see "Equatability.CAN_EQUAL"
     */
    public boolean canEqual(Equatable<?> that) {
        return true;
    }

    public Class<? extends T> getDeclaredType() {
        return this.type;
    }


    /**
     * Policies of when 2 instances can be compared for equality without breaking the equals contract (reflexive/symmetric/transitive)
     */
    public enum Equatability {

        /**
         * Objects areEquatable iff they have equal {@code this.getClass()}.
         * <p>
         * Simple but fails if the class is replaced by a proxy (eg. by Hibernate).
         * Also of course not as flexible as CAN_EQUAL (but that is rarely required).
         */
        SAME_RUNTIME_CLASS {
            @Override protected boolean areEquatable(
                Equatable<?> thisObj, Class<?> thisObjType,
                Equatable<?> thatObj, Class<?> thatObjType
            ) {
                return Objects.equals(thisObj.getClass(), thatObj.getClass());
//                //TODO: fix the (shouldn't)'s and do the same for the other enum constants
//                //OTHER interpretations
//                return Objects.equals(thisObj.getClass(), thatObj.getClass()); //PASSES
//                return thisObj.getClass() == thatObj.getClass()); //PASSES
//                return false;//FAILS(good)
//                return true;//FAILS(good)
//                return thisObj.getClass().isAssignableFrom(thatObj.getClass()); //PASSES(shouldn't)
//                return thatObj.getClass().isAssignableFrom(thisObj.getClass()); //PASSES(shouldn't)

//                //OTHER impls
//                return //PASSES(shouldn't)
//                    thisObjType.isInstance(thatObj)
//                    &&
//                    thatObjType.isInstance(thisObj)
//                ;
//                return //FAILS(good)
//                    thisObj.canEqual(thatObj)
//                    &&
//                    thatObj.canEqual(thisObj)
//                ;
            }
        },

        /**
         * Objects areEquatable iff they have equal {@code this.type}.
         *
         * Simple and unlike SAME_RUNTIME_CLASS, doesn't fail if the class is replaced by a proxy (eg. by Hibernate).
         * Also of course not as flexible as CAN_EQUAL (but that is rarely required).
         */
        SAME_DECLARED_CLASS {
            @Override protected boolean areEquatable(
                Equatable<?> thisObj, Class<?> thisObjType,
                Equatable<?> thatObj, Class<?> thatObjType
            ) {
                return Objects.equals(thisObjType, thatObjType);
            }
        },

        /**
         * Objects areEquatable iff they are instances of each other's {@code type}.
         *
         * Simple and unlike SAME_RUNTIME_CLASS, doesn't fail if the class is replaced by a proxy (eg. by Hibernate).
         * Also of course not as flexible as CAN_EQUAL (but that is rarely required).
         * TODO: vraiment moins flexible?
         */
        IS_INSTANCE{
            @Override protected boolean areEquatable(
                Equatable<?> thisObj, Class<?> thisObjType,
                Equatable<?> thatObj, Class<?> thatObjType
            ) {
                return
                    thisObjType.isInstance(thatObj)
                    &&
                    thatObjType.isInstance(thisObj)
                ;
            }
        },

        /**
         * Objects areEquatable iff they {@code canEqual} each other.
         *
         * The most flexible pattern, initially from Effective Java (nice article about the EJ "canEqual" pattern: https://www.artima.com/lejava/articles/equality.html).
         * Unlike SAME_RUNTIME_CLASS, doesn't fail if the class is replaced by a proxy (eg. by Hibernate).
         *
         * Allows distinguishing derived classes that:
         * <ul>
         * <li>do add state and should not compare equal to their parent</li>
         * <li>do not add state and could compare equal to their parent</li>
     *   * </ul>
         */
        CAN_EQUAL{
            @Override protected boolean areEquatable(
                Equatable<?> thisObj, Class<?> thisObjType,
                Equatable<?> thatObj, Class<?> thatObjType
            ) {
                return
                    thisObj.canEqual(thatObj)
                    &&
                    thatObj.canEqual(thisObj)
                ;
            }
        },
        ;

        public static final Equatability DEFAULT = SAME_DECLARED_CLASS;

        /**
         * Don't allow just any concrete types to be equal, as this can break the reflexive/symmetric/transitive contract
         */
        public final boolean areEquatable(
            Equatable<?> thisObj, Class<?> thisObjType,
            Object thatObj
        ) {
            thisObj = requireNonNull(thisObj);
            thisObjType = requireNonNull(thisObjType);

            if(!(thatObj instanceof Equatable)) return false;
            Equatable<?> thatVo = (Equatable<?>) thatObj;
            Class<?> thatObjType = thatVo.type;

            return areEquatable(thisObj, thisObjType, thatVo, thatObjType);
        }

        protected abstract boolean areEquatable(
            Equatable<?> thisObj, Class<?> thisObjType,
            Equatable<?> thatObj, Class<?> thatObjType
        );
    }

}


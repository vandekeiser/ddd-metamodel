package fr.cla.ddd.oo;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

//@formatter:off
/**
 * TODO
 */
public abstract class Equatable<T extends Equatable<T>> {

    private final Class<T> type;
    private final Equatability equatability;

    protected Equatable(Class<T> type) {
        this(type, Equatability.DEFAULT);
    }

    protected Equatable(Class<T> type, Equatability equatability) {
        this.type = requireNonNull(type);
        this.equatability = requireNonNull(equatability);
    }

    @Override public final boolean equals(Object obj) {
        //An optimization, but also avoids StackOverflows on cyclic object graphs.
        if(obj == this) return true;

        if(! equatability.areEquatable(this, type, obj)) return false;

        T that = type.cast(obj);

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

    /**
     * @see "Equatability.CAN_EQUAL"
     */
    protected boolean canEqual(Equatable<?> that) {
        return true;
    }




    public enum Equatability {
        /**
         * The most simple, we're sure to respect the Object::equals contract without collaboration from the concrete classes.
         * On the other hand this fails if the class is replaced at load-time by a proxy (eg. by Hibernate).
         * Also of course this isn't as flexible as CAN_EQUAL, as there is now way to still be equal even without adding state.
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

        SAME_DECLARED_CLASS {
            @Override protected boolean areEquatable(
                Equatable<?> thisObj, Class<?> thisObjType,
                Equatable<?> thatObj, Class<?> thatObjType
            ) {
                return Objects.equals(thisObjType, thatObjType);
            }
        },

        /**
         * KO if we want to keep AbstractValueObject_PbtTest::equals_should_be_false_for_different_types,
         *  as this doesn't prevent VO1A eq VO1B
         * OK otherwise.
         *
         * This has the advantage of working in the face of Hibernate proxies.
         * It also allows a derived VO to compare equal to its parent while still respecting the Object::equals contract iff:
         * -it adds no state compared to its parent class
         *
         * But is not always fine-grained enough, as it doesn't allow distinguishing:
         *  -derived classes that do add state and should not compare equal to their parent
         *  -derived classes that do not add state and could compare equal to their parent
         * That degree of fine-grained control requires using CAN_EQUAL,
         *  and placing canEqual overrides in coordination with adding state or not.
         *  (this then becomes the responsibility of the derived class)
         *
         *  TODO: test with Hibernate-instrumented class where the concrete class is a load-type proxy
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
         * The most flexible pattern, initially from the Java bible "Effective Java".
         * https://www.artima.com/lejava/articles/equality.html: nice article about the EJ "canEqual" pattern.
         *
         * This could allow to keep strict concrete class same-type policy when Hibernate modifies our class
         *  but we want to ignore that from an equality point of view.
         *
         * TODO: test with Hibernate-instrumented class where the concrete class is a load-type proxy
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
         * @throws NullPointerException iff thisObj or thisObjType is null (which is impossible from the equals method)
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
//@formatter:on

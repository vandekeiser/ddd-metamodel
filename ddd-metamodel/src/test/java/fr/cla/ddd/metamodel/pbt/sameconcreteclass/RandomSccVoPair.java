package fr.cla.ddd.metamodel.pbt.sameconcreteclass;

import com.pholser.junit.quickcheck.From;
import fr.cla.ddd.metamodel.pbt.sameconcreteclass.SccVoPairGenerator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//@formatter:off
@Target({PARAMETER, FIELD, ANNOTATION_TYPE, TYPE_USE})
@Retention(RUNTIME)
@From(SccVoPairGenerator.class)
public @interface RandomSccVoPair {

}
//@formatter:on

package fr.cla.ddd.oo.pbt.isinstance;

import com.pholser.junit.quickcheck.From;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//@formatter:off
@Target({PARAMETER, FIELD, ANNOTATION_TYPE, TYPE_USE})
@Retention(RUNTIME)
@From(IiVoGenerator.class)
public @interface RandomIiVo {

}
//@formatter:on

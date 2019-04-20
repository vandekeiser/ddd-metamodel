package fr.cla.ddd.oo.pbt;

import net.jqwik.api.GenerationMode;
import net.jqwik.api.Property;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static fr.cla.ddd.oo.pbt.PropertyCheck.PROPERTY_CHECK_MAX_DISCARD_RATIO;
import static fr.cla.ddd.oo.pbt.SanityCheck.SANITY_CHECK_TRIALS;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
//@Property(tries = PROPERTY_TRIALS)
@Property(generation = GenerationMode.RANDOMIZED,
    tries = SANITY_CHECK_TRIALS,
    maxDiscardRatio = PROPERTY_CHECK_MAX_DISCARD_RATIO
)
public @interface PropertyCheck {

    //If we need N trials to be sure to have non trivial input, we need more to test the funtionnality
    int PROPERTY_TRIALS = 10 * SANITY_CHECK_TRIALS;
    int PROPERTY_CHECK_MAX_DISCARD_RATIO = PROPERTY_TRIALS/10;

}

package fr.cla.ddd.oo.pbt;

import net.jqwik.api.GenerationMode;
import net.jqwik.api.Property;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static fr.cla.ddd.oo.pbt.SanityCheck.SANITY_CHECK_TRIALS;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Property(tries = SANITY_CHECK_TRIALS, generation = GenerationMode.RANDOMIZED)
public @interface SanityCheck {

    int SANITY_CHECK_TRIALS = 10_000;

    //If we need N trials to be sure to have non trivial input, we need more to test the funtionnality
    int PROPERTY_TRIALS = 10 * SANITY_CHECK_TRIALS;

}

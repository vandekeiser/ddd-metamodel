package fr.cla.ddd.oo.pbt;

import net.jqwik.api.GenerationMode;
import net.jqwik.api.Property;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static fr.cla.ddd.oo.pbt.SanityCheck.SANITY_CHECK_MAX_DISCARD_RATIO;
import static fr.cla.ddd.oo.pbt.SanityCheck.SANITY_CHECK_TRIALS;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Property(
    generation = GenerationMode.RANDOMIZED,
    tries = SANITY_CHECK_TRIALS,
    maxDiscardRatio = SANITY_CHECK_MAX_DISCARD_RATIO
)
public @interface SanityCheck {

    int SANITY_CHECK_TRIALS = 10_000;
    int SANITY_CHECK_MAX_DISCARD_RATIO = SANITY_CHECK_TRIALS/10;

}

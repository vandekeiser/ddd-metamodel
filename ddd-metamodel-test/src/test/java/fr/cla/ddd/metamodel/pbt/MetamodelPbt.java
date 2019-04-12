package fr.cla.ddd.metamodel.pbt;

public final class MetamodelPbt {

    public static final int SANITY_CHECK_TRIALS = 10_000;

    //If we need N trials to be sure to have non trivial input, we need more to test the funtionnality
    public static final int PROPERTY_TRIALS = 10 * SANITY_CHECK_TRIALS;

}

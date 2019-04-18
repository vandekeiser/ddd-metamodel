package fr.cla.ddd.oo.pbt.sameruntimeclass;


import fr.cla.ddd.oo.pbt.EquatablePair;
import fr.cla.ddd.oo.pbt.EquatableSingleton;
import fr.cla.ddd.oo.pbt.EquatableTriplet;
import fr.cla.ddd.oo.pbt.PropertyCheck;
import fr.cla.ddd.oo.pbt.sameruntimeclass.generator.ArbitrarySrcs;
import net.jqwik.api.ForAll;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
public class SrcSatisfiesGeneralEqualsAndHashcodeContractTest
extends ArbitrarySrcs {

    @PropertyCheck
    public void equals_should_be_reflexive(@ForAll("equatableSingletons") EquatableSingleton s) {
        assertThat(
            s.x.equals(s.x)
        ).isTrue();
    }


    @PropertyCheck
    public void equals_should_be_symmetric(@ForAll("equatablePairs") EquatablePair p) {
        assertThat(
            p.x.equals(p.y)
        ).isEqualTo(
            p.y.equals(p.x)
        );
    }

    @PropertyCheck
    public void equals_should_be_transitive(@ForAll("equatableTriplets") EquatableTriplet t) {
        if(t.x.equals(t.y) && t.y.equals(t.z)){
            assertThat(t.x.equals(t.z)).isTrue();
        }
    }

    @PropertyCheck
    public void equals_null_should_be_false(@ForAll("equatableSingletons") EquatableSingleton s) {
        assertThat(
           s.x.equals(null)
        ).isFalse();
    }

    @PropertyCheck
    public void equals_should_be_consistent(@ForAll("equatablePairs") EquatablePair p) {
        assertThat(
            p.x.equals(p.y)
        ).isEqualTo(
            p.x.equals(p.y)
        );
    }

    @PropertyCheck
    public void equals_implies_same_hashCode(@ForAll("equatablePairs") EquatablePair p) {
        if(p.x.equals(p.y)){
            assertThat(
                p.x.hashCode()
            ).isEqualTo(
                p.y.hashCode()
            );
        }
    }

    @PropertyCheck
    public void hashCode_should_be_consistent(@ForAll("equatableSingletons") EquatableSingleton s) {
        assertThat(
            s.x.hashCode()
        ).isEqualTo(
            s.x.hashCode()
        );
    }

}
//@formatter:on

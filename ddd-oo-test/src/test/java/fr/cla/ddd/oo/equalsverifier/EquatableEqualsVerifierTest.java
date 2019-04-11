package fr.cla.ddd.oo.equalsverifier;

import fr.cla.ddd.oo.example.equatables.sameconcreteclass.SccVO1;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Ignore;
import org.junit.Test;

//@formatter:off
public class EquatableEqualsVerifierTest {

    @Test @Ignore
    public void VO1_should_respect_contract() {
        EqualsVerifier.forClass(SccVO1.class)
            .withGenericPrefabValues(Class.class, t -> SccVO1.class)
            .withIgnoredFields()
        .verify();
    }



}
//@formatter:on
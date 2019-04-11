package fr.cla.ddd.metamodel.equalsverifier;

import fr.cla.ddd.metamodel.example.vos.sameconcreteclass.SccVO1;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Ignore;
import org.junit.Test;

//@formatter:off
public class AbstractValueObjectEqualsVerifierTest {

    @Test @Ignore
    public void VO1_should_respect_contract() {
        EqualsVerifier.forClass(SccVO1.class)
            .withGenericPrefabValues(Class.class, t -> SccVO1.class)
            .withIgnoredFields()
        .verify();
    }



}
//@formatter:on
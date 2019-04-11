package fr.cla.ddd.oo.equalsverifier;

import fr.cla.ddd.oo.example.equatables.sameconcreteclass.SccVO1;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

//@formatter:off
public class EquatableEqualsVerifierTest {

    @Test
    @Disabled //don't like how it tries to change private fields
    public void VO1_should_respect_contract() {
        EqualsVerifier.forClass(SccVO1.class)
            .withGenericPrefabValues(Class.class, t -> SccVO1.class)
            .withIgnoredFields()
        .verify();
    }

}
//@formatter:on
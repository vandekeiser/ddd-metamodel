package fr.cla.ddd.oo.example.equatables.canequal;

import fr.cla.ddd.oo.example.equatables.Value;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
public class CanEqualTest {

    @Test
    public void cevo1_canequal_cevo1() {
        CeVO1 cevo1 = new CeVO1(Value.V1);
        CeVO1 cevo2 = new CeVO1(Value.V1);
        assertThat(
            cevo1.equals(cevo2)
        ).isTrue();
    }

    @Test
    public void cevo1_canequal_cevo1A() {
        CeVO1 cevo1 = new CeVO1(Value.V1);
        CeVO1A cevo1A = new CeVO1A(Value.V1);
        assertThat(
            cevo1A.equals(cevo1)
        ).isTrue();
    }

    @Test
    public void cevo1_cannotequal_cevo1B() {
        CeVO1 cevo1 = new CeVO1(Value.V1);
        CeVO1B cevo1B = new CeVO1B(Value.V1, Value.V1);
        assertThat(
            cevo1B.equals(cevo1)
        ).isFalse();
    }

    @Test
    public void cevo1A_cannotequal_cevo1B() {
        CeVO1A cevo1A = new CeVO1A(Value.V1);
        CeVO1B cevo1B = new CeVO1B(Value.V1, Value.V1);
        assertThat(
            cevo1B.equals(cevo1A)
        ).isFalse();
    }

}
//@formatter:on
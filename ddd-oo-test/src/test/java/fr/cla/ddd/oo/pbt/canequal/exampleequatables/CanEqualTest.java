package fr.cla.ddd.oo.pbt.canequal.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
public class CanEqualTest {

    @Test
    public void cevo1_canequal_cevo1() {
        var cevo1 = new CeVO1(Value.V1);
        var cevo2 = new CeVO1(Value.V1);

        assertThat(
            cevo1.equals(cevo2)
        ).isTrue();
    }

    @Test
    public void cevo1_canequal_cevo1A() {
        var cevo1 = new CeVO1(Value.V1);
        var cevo1A = new CeVO1A(Value.V1);

        assertThat(
            cevo1A.equals(cevo1)
        ).isTrue();
    }

    @Test
    public void cevo1A_canequal_cevo1() {
        var cevo1 = new CeVO1(Value.V1);
        var cevo1A = new CeVO1A(Value.V1);

        assertThat(
            cevo1.equals(cevo1A)
        ).isTrue();
    }

    @Test
    public void cevo1_cannotequal_cevo1B() {
        var cevo1 = new CeVO1(Value.V1);
        var cevo1B = new CeVO1B(Value.V1, Value.V1);

        assertThat(
            cevo1B.equals(cevo1)
        ).isFalse();
    }

    @Test
    public void cevo1A_cannotequal_cevo1B() {
        var cevo1A = new CeVO1A(Value.V1);
        var cevo1B = new CeVO1B(Value.V1, Value.V1);

        assertThat(
            cevo1B.equals(cevo1A)
        ).isFalse();
    }

}
//@formatter:on
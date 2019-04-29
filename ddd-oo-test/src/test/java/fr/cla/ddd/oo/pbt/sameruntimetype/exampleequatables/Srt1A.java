package fr.cla.ddd.oo.pbt.sameruntimetype.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public final class Srt1A extends Srt1 {

    private final Value y;

    public Srt1A(Value y, Value x) {
        super(Srt1A.class, x);
        this.y = y;
    }

    public static Srt1A random() {
        return new Srt1A(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}

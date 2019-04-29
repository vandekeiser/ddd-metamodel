package fr.cla.ddd.oo.pbt.sameruntimetype.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public final class Srt2A extends Srt2 {

    private final Value y;

    public Srt2A(Value y, Value x) {
        super(Srt2A.class, x);
        this.y = y;
    }

    public static Srt2A random() {
        return new Srt2A(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}

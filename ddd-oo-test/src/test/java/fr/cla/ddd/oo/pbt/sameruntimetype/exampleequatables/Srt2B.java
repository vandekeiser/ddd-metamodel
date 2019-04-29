package fr.cla.ddd.oo.pbt.sameruntimetype.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public final class Srt2B extends Srt2 {

    private final Value y;

    public Srt2B(Value y, Value x) {
        super(Srt2B.class, x);
        this.y = y;
    }

    public static Srt2B random() {
        return new Srt2B(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}

package fr.cla.ddd.oo.pbt.sameruntimetype.exampleequatables;

import fr.cla.ddd.oo.pbt.Value;

import java.util.Arrays;
import java.util.List;


public final class Srt1B extends Srt1 {

    private final Value y;

    public Srt1B(Value y, Value x) {
        super(Srt1B.class, x);
        this.y = y;
    }

    public static Srt1B random() {
        return new Srt1B(
            Value.random(),
            Value.random()
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(super.x, y);
    }

}

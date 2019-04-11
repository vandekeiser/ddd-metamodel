package fr.cla.ddd.metamodel;

import fr.cla.ddd.oo.Equatable;

import java.util.List;

import static java.lang.System.out;
import static java.util.Collections.singletonList;

public class Main {

    public static void main(String[] args) {
        out.println(new VO1("foo"));
        out.println(new VO1("bar"));
    }

    public static class Eq1 extends Equatable<Eq1> {
        protected final String x;

        public Eq1(String x) {
            super(Eq1.class);
            this.x = x;
        }

        @Override
        protected List<Object> equalityCriteria() {
            return singletonList(x);
        }
    }

    public static class VO1 extends AbstractValueObject<VO1> {

        protected final String x;

        public VO1(String x) {
            super(VO1.class);
            this.x = x;
        }
        @Override
        protected List<Object> equalityCriteria() {
            return singletonList(x);
        }

    }

}
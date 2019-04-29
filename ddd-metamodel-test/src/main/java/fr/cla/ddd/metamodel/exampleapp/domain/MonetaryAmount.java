package fr.cla.ddd.metamodel.exampleapp.domain;

import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.validation.Validations;
import fr.cla.ddd.metamodel.validation.Validator;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static java.util.stream.Collector.Characteristics.*;


@DDD.ValueObject
public class MonetaryAmount extends AbstractValueObject<MonetaryAmount> {

    private final int amount;

    public MonetaryAmount(int amount) {
        super(MonetaryAmount.class);
        this.amount = amount;
        validate();
    }

    public static Collector<MonetaryAmount, ?, MonetaryAmount> summing() {
        class MutableMonetaryAmount {
            private int amount;

            MutableMonetaryAmount() {
                this(0);
            }

            MutableMonetaryAmount(int amount) {
                this.amount = amount;
            }

            void add(MonetaryAmount that) {
                amount = Math.addExact(this.amount, that.amount);
            }

            MutableMonetaryAmount add(MutableMonetaryAmount that) {
                return new MutableMonetaryAmount(Math.addExact(this.amount, that.amount));
            }

            MonetaryAmount toImmutable() {
                return new MonetaryAmount(this.amount);
            }
        }

        return Collector.of(
            MutableMonetaryAmount::new,
            MutableMonetaryAmount::add,
            MutableMonetaryAmount::add,
            MutableMonetaryAmount::toImmutable,
            CONCURRENT, UNORDERED
        );
    }

    @Override
    protected List<Object> equalityCriteria() {
        return singletonList(amount);
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public Validator<MonetaryAmount> validator() {
        return Validator.of(MonetaryAmount.class)
            .validate(MonetaryAmount::getAmount, Validations::isPositive, "amount must be positive")
        ;
    }

    //Unfortunately this is required by JPA. Don't use.
    @SuppressWarnings("unused")
    private MonetaryAmount() {
        super(MonetaryAmount.class);
        this.amount = 0;
    }

    public boolean isSmallerThanOrEqualTo(MonetaryAmount that) {
        return this.amount <= that.amount;
    }
}

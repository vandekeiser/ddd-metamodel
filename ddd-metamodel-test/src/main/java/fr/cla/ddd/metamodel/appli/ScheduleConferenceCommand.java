package fr.cla.ddd.metamodel.appli;

import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.domain.Talk;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.*;

@DDD.ValueObject
public class ScheduleConferenceCommand extends AbstractValueObject<ScheduleConferenceCommand> {
    private final MonetaryAmount budget;
    private final Set<MonetaryAmount> costs;

    public ScheduleConferenceCommand(MonetaryAmount budget, Set<MonetaryAmount> costs) {
        super(ScheduleConferenceCommand.class);
        this.budget = requireNonNull(budget);
        this.costs = new HashSet<>(costs);
    }

    @Override
    protected List<Object> equalityCriteria() {
        return asList(budget, costs);
    }

    public MonetaryAmount getBudget() {
        return budget;
    }

    public <T> Set<T> mapCosts(Function<? super MonetaryAmount, ? extends  T> mapper) {
        return costs.stream().map(mapper).collect(toSet());
    }

    @Override
    public String toString() {
        return String.format("{budget:%s, cost:%s}", budget, costs);
    }
}

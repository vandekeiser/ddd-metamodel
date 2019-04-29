package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.AbstractValueObject;
import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimeclass.SrcTalk;
import fr.cla.ddd.metamodel.validation.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toSet;

@DDD.ValueObject
public class ScheduleConferenceCommand extends AbstractValueObject<ScheduleConferenceCommand> {
    private final ConferenceId conferenceId;
    private final MonetaryAmount budget;
    private final Set<MonetaryAmount> costs;

    public ScheduleConferenceCommand(MonetaryAmount budget, Set<MonetaryAmount> costs) {
        super(ScheduleConferenceCommand.class);
        this.budget = requireNonNull(budget);
        this.costs = new HashSet<>(costs);
        this.conferenceId = new ConferenceId();
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

    public SrcConference toConference() {
        return new SrcConference(
            conferenceId,
            budget,
            mapCosts(SrcTalk::new)
        );
    }

    @Override
    public Validator<ScheduleConferenceCommand> validator() {
        return Validator.none();
    }

    @Override
    public String toString() {
        return String.format("{budget:%s, cost:%s}", budget, costs);
    }

}

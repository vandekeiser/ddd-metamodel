package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.DDD;
import fr.cla.ddd.metamodel.domain.AbstractValueObject;
import fr.cla.ddd.metamodel.domain.validation.Constraints;
import fr.cla.ddd.metamodel.domain.validation.InvalidObjectException;
import fr.cla.ddd.metamodel.domain.validation.Validator;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtTalk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

@DDD.ValueObject
public class ScheduleConferenceCommand extends AbstractValueObject<ScheduleConferenceCommand> {
    private final ConferenceId conferenceId;
    private final MonetaryAmount budget;
    private final List<MonetaryAmount> costs;

    public ScheduleConferenceCommand(MonetaryAmount budget, List<MonetaryAmount> costs) {
        super(ScheduleConferenceCommand.class);
        this.budget = budget;
        this.costs = new ArrayList<>(costs);
        this.conferenceId = new ConferenceId();
        validate();
    }

    @Override
    protected List<Object> equalityCriteria() {
        return asList(conferenceId, budget, costs);
    }

    public MonetaryAmount getBudget() {
        return budget;
    }

    public <T> List<T> mapCosts(Function<? super MonetaryAmount, ? extends  T> mapper) {
        return costs.stream().map(mapper).collect(toList());
    }

    public SrtConference createConference() {
        return new SrtConference(
            conferenceId,
            budget,
            new HashSet<>(mapCosts(SrtTalk::new))
        );
    }

    @Override
    public Validator<ScheduleConferenceCommand> validator() {
        return Validator.of(ScheduleConferenceCommand.class)
            .validate(ScheduleConferenceCommand::getBudget, Constraints::isNotNull, "budget must not be null")
        ;
    }

    @Override
    public String toString() {
        return String.format(
            "%s{conferenceId:%s, budget:%s, costs:%s}",
            getDeclaredType().getSimpleName(), conferenceId, budget, costs
        );
    }

}

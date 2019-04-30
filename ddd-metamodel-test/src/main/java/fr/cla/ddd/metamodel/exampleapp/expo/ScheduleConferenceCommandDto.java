package fr.cla.ddd.metamodel.exampleapp.expo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.cla.ddd.metamodel.exampleapp.appli.ScheduleConferenceCommand;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ScheduleConferenceCommandDto {

    @JsonProperty public /*final*/ int budget;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Integer> getCosts() {
        return costs;
    }

    public void setCosts(List<Integer> costs) {
        this.costs = costs;
    }

    @JsonProperty public /*final*/ List<Integer> costs;

    @JsonCreator
    public ScheduleConferenceCommandDto(
        @JsonProperty("budget") int budget,
        @JsonProperty("costs") List<Integer> costs)
    {
        this.budget = budget;
        this.costs = costs;
    }

    public ScheduleConferenceCommand toCommand() {
        return new ScheduleConferenceCommand(
            new MonetaryAmount(budget),
            costs.stream().map(MonetaryAmount::new).collect(toList())
        );
    }
}

package fr.cla.ddd.metamodel.exampleapp.expo.conference;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.cla.ddd.metamodel.exampleapp.appli.ScheduleConferenceCommand;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ScheduleConferenceCommandDto {

    @JsonProperty private final int budget;
    @JsonProperty private final List<Integer> costs;

    @JsonCreator //Request DTOs are constructed by jackson
    public ScheduleConferenceCommandDto(
        //@JsonProperty required to not get unfriendly 415 from spring..
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

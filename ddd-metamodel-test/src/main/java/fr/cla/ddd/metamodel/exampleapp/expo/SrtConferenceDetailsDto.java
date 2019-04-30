package fr.cla.ddd.metamodel.exampleapp.expo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.cla.ddd.metamodel.exampleapp.appli.SrtConferenceDetails;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConference;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class SrtConferenceDetailsDto {

    @JsonProperty public /*final*/ String id;
    @JsonProperty public /*final*/ int budget;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public Set<SrtTalkDto> getTalks() {
        return talks;
    }

    public void setTalks(Set<SrtTalkDto> talks) {
        this.talks = talks;
    }

    @JsonProperty public /*final*/ int totalCost;
    @JsonProperty public /*final*/ Set<SrtTalkDto> talks;

    @JsonCreator
    public SrtConferenceDetailsDto(SrtConferenceDetails details) {
        this.id = details.getId().getValue();
        this.budget = details.getBudget().getAmount();
        this.totalCost = details.getTotalCost().getAmount();
        this.talks = details.getTalks().stream().map(SrtTalkDto::new).collect(toSet());
    }

}

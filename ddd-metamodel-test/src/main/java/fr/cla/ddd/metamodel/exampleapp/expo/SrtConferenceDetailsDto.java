package fr.cla.ddd.metamodel.exampleapp.expo;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.cla.ddd.metamodel.exampleapp.appli.SrtConferenceDetails;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConference;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class SrtConferenceDetailsDto {

    @JsonProperty public final String id;
    @JsonProperty public final int budget;
    @JsonProperty public final Set<SrtTalkDto> talks;

    public SrtConferenceDetailsDto(SrtConferenceDetails details) {
        this.id = details.getId().getValue();
        this.budget = details.getBudget().getAmount();
        this.talks = details.getTalks().stream().map(SrtTalkDto::new).collect(toSet());
    }

}

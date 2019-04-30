package fr.cla.ddd.metamodel.exampleapp.expo;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConference;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class SrtConferenceDetailsDto {

    @JsonProperty public final String id;
    @JsonProperty public final int budget;
    @JsonProperty public final Set<SrtTalkDto> talks;

    public SrtConferenceDetailsDto(SrtConference srtConference) {
        this.id = srtConference.getId().getValue();
        this.budget = srtConference.getBudget().getAmount();
        this.talks = srtConference.getTalks().stream().map(SrtTalkDto::new).collect(toSet());
    }

}

package fr.cla.ddd.metamodel.exampleapp.expo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtTalk;

public class SrtTalkDto {

    @JsonProperty public final String id;
    @JsonProperty public final int cost;

    public SrtTalkDto(SrtTalk srtTalk) {
        this.id = srtTalk.getId().getValue();
        this.cost = srtTalk.getCost().getAmount();
    }

}

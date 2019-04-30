package fr.cla.ddd.metamodel.exampleapp.expo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtTalk;

public class SrtTalkDto {

    @JsonProperty public /*final*/ String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @JsonProperty public /*final*/ int cost;

    @JsonCreator
    public SrtTalkDto(SrtTalk srtTalk) {
        this.id = srtTalk.getId().getValue();
        this.cost = srtTalk.getCost().getAmount();
    }

}

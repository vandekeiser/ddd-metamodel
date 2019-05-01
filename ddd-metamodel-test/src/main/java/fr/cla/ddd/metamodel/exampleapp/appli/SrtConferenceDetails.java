package fr.cla.ddd.metamodel.exampleapp.appli;

import fr.cla.ddd.metamodel.domain.AbstractValueObject;
import fr.cla.ddd.metamodel.domain.validation.Constraints;
import fr.cla.ddd.metamodel.domain.validation.Validator;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtConference;
import fr.cla.ddd.metamodel.exampleapp.domain.equatability.sameruntimetype.SrtTalk;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SrtConferenceDetails extends AbstractValueObject<SrtConferenceDetails> {

    private final ConferenceId id;
    private final MonetaryAmount budget;
    private final MonetaryAmount totalCost;
    private final Set<SrtTalk> talks;

    public SrtConferenceDetails(SrtConference conf) {
        this(
            conf.getId(),
            conf.getBudget(),
            conf.totalCost(),
            new HashSet<>(conf.getTalks())
        );
    }

    public SrtConferenceDetails(ConferenceId id, MonetaryAmount budget, MonetaryAmount totalCost, Set<SrtTalk> talks) {
        super(SrtConferenceDetails.class);
        this.id = id;
        this.budget = budget;
        this.totalCost = totalCost;
        this.talks = talks;
    }

    @Override
    public Validator<? super SrtConferenceDetails> validator() {
        return Validator.of(SrtConferenceDetails.class)
            .validate(SrtConferenceDetails::getId, Constraints::isNotNull, "id must not be null")
            .validate(SrtConferenceDetails::getBudget, Constraints::isNotNull, "budget must not be null")
            .validate(SrtConferenceDetails::getTotalCost, Constraints::isNotNull, "total cost must not be null")
        ;
    }

    @Override
    protected List<Object> equalityCriteria() {
        return Arrays.asList(id, budget);
    }

    @Override
    public String toString() {
        return String.format(
            "{id:%s, budget:%s, totalCost:%s, talks:%s}",
            id, budget, totalCost, talks
        );
    }

    public ConferenceId getId() {
        return id;
    }

    public MonetaryAmount getBudget() {
        return budget;
    }

    public MonetaryAmount getTotalCost() {
        return totalCost;
    }

    public Set<SrtTalk> getTalks() {
        return new HashSet<>(talks);
    }

}

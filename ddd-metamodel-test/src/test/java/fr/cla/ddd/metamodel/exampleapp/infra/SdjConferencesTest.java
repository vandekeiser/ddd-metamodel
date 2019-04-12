package fr.cla.ddd.metamodel.exampleapp.infra;

import fr.cla.ddd.metamodel.exampleapp.domain.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
//@DataJpaTest
public class SdjConferencesTest {

    @Autowired private SdjConferences sut;

    @Test
    @Disabled //TODO
    public void should_find_persisted_entity() {
        Conference conf;

        given: {
            conf = scheduleConference();
            assertThat(
                sut.get(conf.getId())
            ).isEmpty();
        }

        when: {
            sut.add(conf);
        }

        then: {
            assertThat(
                sut.get(conf.getId())
            ).isEqualTo(
                Optional.of(conf)
            );
        }
    }

    private Conference scheduleConference() {
        return new Conference(
            new ConferenceId(),
            new MonetaryAmount(1000),
            new Talk(new MonetaryAmount(100)),
            new Talk(new MonetaryAmount(200))
        );
    }

}
//@formatter:on
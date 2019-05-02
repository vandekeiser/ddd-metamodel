package fr.cla.ddd.metamodel.exampleapp.expo;

import fr.cla.ddd.metamodel.appli.validation.ApplicativeValidations;
import fr.cla.ddd.metamodel.exampleapp.appli.ScheduleConference;
import fr.cla.ddd.metamodel.exampleapp.appli.ScheduleConferenceCommand;
import fr.cla.ddd.metamodel.exampleapp.expo.conference.ConferenceController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.any;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public abstract class AbstractContractVerifierTest {

    @Autowired private WebApplicationContext ctx;
    @Autowired private ConferenceController controller;
    @MockBean private ScheduleConference applicationService;

    @BeforeEach
    public void setup() {
        setupRestAssured();
        mockApplicationService__makeItJustDoApplicativeValidation();
    }

    private void setupRestAssured() {
        RestAssuredMockMvc.webAppContextSetup(ctx);
    }

    private void mockApplicationService__makeItJustDoApplicativeValidation() {
        Mockito.doAnswer(
            justDoApplicativeValidation()
        ).when(applicationService).scheduleConference(any(ScheduleConferenceCommand.class));
    }

    private Answer<Void> justDoApplicativeValidation() {
        return invocationOnMock -> {
            ScheduleConferenceCommand cmd = invocationOnMock.getArgument(0);
            ApplicativeValidations.validateApplicatively(cmd, ScheduleConferenceCommand::createConference);
            return null;
        };
    }

}

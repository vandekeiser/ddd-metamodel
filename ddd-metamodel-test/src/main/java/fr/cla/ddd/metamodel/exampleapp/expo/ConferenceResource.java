package fr.cla.ddd.metamodel.exampleapp.expo;

import fr.cla.ddd.metamodel.exampleapp.appli.ScheduleConference;
import fr.cla.ddd.metamodel.exampleapp.appli.ScheduleConferenceCommand;
import fr.cla.ddd.metamodel.exampleapp.appli.ViewConferenceDetails;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static java.util.Objects.requireNonNull;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/example-app/conferences")
public class ConferenceResource {

    private final ScheduleConference scheduleConference;
    private final ViewConferenceDetails viewConferenceDetails;

    public ConferenceResource(ScheduleConference scheduleConference, ViewConferenceDetails viewConferenceDetails) {
        this.scheduleConference = requireNonNull(scheduleConference);
        this.viewConferenceDetails = requireNonNull(viewConferenceDetails);
    }

    @GetMapping(value = "/{conferenceId}", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SrtConferenceDetailsDto> viewConferenceDetails(
        @PathVariable("conferenceId") String conferenceId
    ){
        ConferenceId id = new ConferenceId(conferenceId);
        Optional<SrtConferenceDetailsDto> maybeConf = viewConferenceDetails.viewConferenceDetails(id).map(SrtConferenceDetailsDto::new);
        return ResponseEntity.of(maybeConf);
    }

    @PostMapping(value = "/", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(CREATED)
    public void scheduleConferenceCommand(
        @RequestBody ScheduleConferenceCommandDto scheduleConferenceCommandDto
    ){
        ScheduleConferenceCommand cmd = scheduleConferenceCommandDto.toCommand();
        scheduleConference.scheduleConference(cmd);
    }

}

package fr.cla.ddd.metamodel.exampleapp.expo;

import fr.cla.ddd.metamodel.exampleapp.appli.ScheduleConference;
import fr.cla.ddd.metamodel.exampleapp.appli.ViewConferenceDetails;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("/v1/conferences")
public class ConferenceResource {

    private final ScheduleConference scheduleConference;
    private final ViewConferenceDetails viewConferenceDetails;

    public ConferenceResource(ScheduleConference scheduleConference, ViewConferenceDetails viewConferenceDetails) {
        this.scheduleConference = requireNonNull(scheduleConference);
        this.viewConferenceDetails = requireNonNull(viewConferenceDetails);
    }

//    @PostMapping(value = "/conferences")
//    public void scheduleConferenceCommand(@RequestBody ScheduleConferenceCommandDto scheduleConferenceCommandDto){
//        ScheduleConferenceCommand cmd = scheduleConferenceCommandDto.toCommand();
//        scheduleConference.scheduleConference(cmd);
//    }

    @GetMapping(value = "/{conferenceId}")
    public ResponseEntity<SrtConferenceDetailsDto> getPayor(@PathVariable("conferenceId") String conferenceId){
        ConferenceId id = new ConferenceId(conferenceId);
        Optional<SrtConferenceDetailsDto> maybeConf = viewConferenceDetails.viewConferenceDetails(id).map(SrtConferenceDetailsDto::new);
        return ResponseEntity.of(maybeConf);
    }

}

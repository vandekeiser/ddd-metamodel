package fr.cla.ddd.metamodel.expo;

import fr.cla.ddd.metamodel.appli.ScheduleConference;
import fr.cla.ddd.metamodel.appli.ScheduleConferenceCommand;
import fr.cla.ddd.metamodel.appli.ViewConferenceDetails;
import fr.cla.ddd.metamodel.domain.Conference;
import fr.cla.ddd.metamodel.domain.ConferenceId;
import fr.cla.ddd.metamodel.domain.MonetaryAmount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class CliApp {

    private static final Logger log = LoggerFactory.getLogger(CliApp.class);

    public static void main(String[] args) {
        SpringApplication.run(CliApp.class);
    }

    @Bean
    public CommandLineRunner demo(
        ScheduleConference schedConf, ViewConferenceDetails viewConf
    ) {
        return (args) -> {
            ScheduleConferenceCommand schedCmd = schedCmd(args);
            log.info("Scheduling " + schedCmd);
            ConferenceId scheduledConfId = schedConf.scheduleConference(schedCmd);
            log.info("Scheduled " + scheduledConfId);

            Optional<Conference> reloadedConf = viewConf.viewConferenceDetails(scheduledConfId);
            log.info("Reloaded " + reloadedConf);

        };
    }

    private ScheduleConferenceCommand schedCmd(String[] args) {
        return new ScheduleConferenceCommand(
            new MonetaryAmount(1000),
            Set.of(new MonetaryAmount(200), new MonetaryAmount(300), new MonetaryAmount(500))
        );
    }

}

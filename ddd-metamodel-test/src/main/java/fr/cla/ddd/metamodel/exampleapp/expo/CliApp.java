package fr.cla.ddd.metamodel.exampleapp.expo;

import fr.cla.ddd.metamodel.exampleapp.ExampleApp;
import fr.cla.ddd.metamodel.exampleapp.appli.ScheduleConference;
import fr.cla.ddd.metamodel.exampleapp.appli.ScheduleConferenceCommand;
import fr.cla.ddd.metamodel.exampleapp.appli.ViewConferenceDetails;
import fr.cla.ddd.metamodel.exampleapp.domain.Conference;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.domain.MonetaryAmount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
import java.util.Set;

@SpringBootApplication(scanBasePackageClasses = ExampleApp.class)
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
            schedConf.scheduleConference(schedCmd);
            log.info("Scheduled " + schedCmd.toConference());

            Optional<Conference> reloadedConf = viewConf.viewConferenceDetails(
                schedCmd.toConference().getId()
            );
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

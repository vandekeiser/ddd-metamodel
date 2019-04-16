package fr.cla.ddd.metamodel.exampleapp.infra;

import fr.cla.ddd.metamodel.exampleapp.ScanApp;
import fr.cla.ddd.metamodel.exampleapp.domain.Conference;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = JpaConfig.class)
@EntityScan(basePackageClasses = Conference.class)
@ComponentScan(basePackageClasses = ScanApp.class)
public class JpaConfig {
}

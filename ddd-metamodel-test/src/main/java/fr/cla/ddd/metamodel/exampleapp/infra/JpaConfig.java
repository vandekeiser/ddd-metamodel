package fr.cla.ddd.metamodel.exampleapp.infra;

import fr.cla.ddd.metamodel.exampleapp.ExampleApp;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = JpaConfig.class)
@ComponentScan(basePackageClasses = ExampleApp.class)
public class JpaConfig {
}

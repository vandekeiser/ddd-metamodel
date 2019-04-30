package fr.cla.ddd.metamodel.exampleapp.expo;

import fr.cla.ddd.metamodel.exampleapp.ExampleApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = ExampleApp.class)
public class RestApp {

    public static void main(String[] args) {
        SpringApplication.run(RestApp.class);
    }

}

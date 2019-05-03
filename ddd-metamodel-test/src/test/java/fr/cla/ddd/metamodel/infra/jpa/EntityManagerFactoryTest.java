package fr.cla.ddd.metamodel.infra.jpa;

import fr.cla.ddd.metamodel.exampleapp.infra.jpa.JpaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ContextConfiguration(classes = JpaConfig.class)
public class EntityManagerFactoryTest {

    @PersistenceContext private EntityManager sut;

    @Test
    public void entity_manager_factory_should_load_without_failure() {
        assertThat(sut).isNotNull();
    }

}

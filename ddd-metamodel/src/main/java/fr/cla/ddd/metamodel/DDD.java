package fr.cla.ddd.metamodel;


import fr.cla.ddd.metamodel.domain.AbstractAggregateRoot;

public class DDD {

    public enum Layer {
        DOMAIN, APPLICATION, INFRASTRUCTURE, EXPOSITION
    }

    public @interface ValueObject {

    }

    public @interface Entity {
        Class<? extends AbstractAggregateRoot<?, ?>> aggregateRoot();
    }

    @ValueObject
    public @interface EntityId {

    }

    public @interface AggregateRoot {

    }

    public @interface DomainService {

    }

    public @interface ApplicationService {

    }

    public @interface Repository {

    }

    public @interface RepositoryImpl {

    }

    public @interface InfrastructureService {

    }

    public @interface InfrastructureServiceImpl {

    }

}

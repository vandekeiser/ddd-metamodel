package fr.cla.ddd.metamodel;

//@formatter:off
public class DDD {

    public enum Layer {
        DOMAIN, APPLICATION, INFRASTRUCTURE, EXPOSITION
    }

    public @interface ValueObject {

    }

    @ValueObject
    public @interface ValueObjectId {

    }

    public @interface Entity {
        //Class<? extends AggregateRoot> aggregateRoot();

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
//@formatter:on
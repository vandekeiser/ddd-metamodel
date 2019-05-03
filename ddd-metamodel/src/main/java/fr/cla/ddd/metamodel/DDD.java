package fr.cla.ddd.metamodel;


import fr.cla.ddd.metamodel.domain.AbstractAggregateRoot;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@DDD.Definition(
    "Domain‐Driven Design is an approach to the development of complex software in which we:" +
    "<ul>" +
    "<li>Focus on the core domain" +
    "<li>Explore models in a creative collaboration of domain practitioners and software practitioners" +
    "<li>Speak a ubiquitous language (UL) within an explicitly bounded context (BC)" +
    "</ul>(Eric Evans)"
)
@DDD.Rule(
    "Design the domain first, not the data or the UI."+
    "Resolve uncertainty in the domain before attempting data modeling or implementing screens and forms."+
    "Putting the cart before the ox will freeze the domain model into a wrong state of false understanding."
)
@DDD.Rule(
    "Decide explicitly upon an Ubiquitous Language."+
    "In a given Bounded Context, at a given instant, the exact same vocabulary must be used to describe business concepts."+
    "On the other hand, do change the UL over time if necessary, either refining the term or the concept behind it."
)
@DDD.Rule(
    "Design and implement iteratively and test-first (aka BDD-first/ATDD)." +
    "It is impossible to model correctly even a moderately complex domain on the first try. " +
    "New concepts will be discovered during iterations, then integrated to the UL."
)
public class DDD {

    @DDD.Variation("The 4 DDD layers: Domain, Application, Infrastructure, and Exposition")
    public enum Layer {
        @DDD.Definition(
            "Contains business logic used by several features, that is ApplicationServices (or by a single ApplicationService, but which is complex enough to be extracted into a DomainService)." +
            "DDD types found inside this layer are ValueObjects, Entities, DomainEvents, DomainServices, and the definition as interfaces of Repositories and InfrastructureServices."
        )
        @DDD.Rule("Structure packages by aggregate root")
        @DDD.Rule(
            "The Infrastructure module must depend from the Domain module, not the other way around." +
            "The Dependency Inversion Principle (DIP) states that:" +
            "<ul>" +
            "<li>High-level modules must not depend on low-level modules. Both must depend on abstractions" +
            "<li>Abstractions must not depend on details. Details must depend on abstractions" +
            "<li>When a domain component needs to invoke an infrastructure component, it must do so through an interface in the Domain layer, whose implementation is in the Infrastructure layer (Separated Interface)" +
            "</ul>"
        )
        DOMAIN,

        @DDD.Definition(
            "Contains business logic used by a single feature, that is ApplicationService" +
            "DDD types found inside this layer are ApplicationServices, their parameters (Command and Queries of type ValueObject), and their returned types (Summaries for lists of elements, Details for single elements, both ValueObjects)."
        )
        @DDD.Rule("Structure packages by epics/themes of features")
        APPLICATION,

        @DDD.Definition("Contains outbound technical logic to call databases, .")
        @DDD.Rule("Structure packages by type of technology (have a jpa subpackage, another restclient subpackage, ..)")
        INFRASTRUCTURE,

        @DDD.Definition("Contains inbound technical logic to accept clients (eg. a REST API).")
        @DDD.Guideline("Have a separate exposition module by port/adapter (that is, have separate myapp-expo-rest/myapp-expo-soap modules)")
        EXPOSITION
    }

    @Definition("A quantative or descriptive immutable value that describes part of the state of an entity at a given time")
    @Rule(
        "Use ValueObjects (VOs) to replace primitives of the language with primitives of the domain." +
        "Designs that use too many low-level types (primitives, strings) are difficult to understand because they’re weakly typed and repetitive. "
    )
    @Rule(
        "Value Objects must have value-based equality." +
        "They have no identity, and two equal instances must be repleacable." +
        "Therefore their equality must be defined by a list of the compared values."
    )
    @Rule(
        "Value Objects must be immutable." +
        "They represent pure values without identity and therefore cannot change. " +
        "Their design must enforce this immutability property (which isn't always trivial). " +
        "Instead of mutating, create a new VO holding the new value."
    )
    @Rule(
        "Use VOs to aggregate magnitude and unit." +
        "Values that come with a unit (ex: MonetaryAmount has a Currency) form a conceptual whole, and are meaningless without their unit. This causes duplication and increases the probability of bugs."
    )
    @Guideline(
        "Favor putting behaviour inside the VO." +
        "Behaviour, not data, should be exposed. Therefore put conversion/parsing/formatting/validation logic/binary operators/... inside the VO to encapsulate data usage."
    )
    @Guideline(
        "Enforce the Value Object invariants in their constructor." +
        "Since they are immutable, if they are validated on construction, they are guaranteed to always be valid."
    )
    @Guideline(
        "Compose fined-grained ValueObjects into coarse-grained ValueObjects." +
        "Since VOs have no lifecycle, they can be composed into several layers of composition without introducing accidental complexity (eg. VOs with several layers of composition can be mapped to just a column in the database)" +
        "Examples: Email+Phone+Address=Contact"
    )
    public @interface ValueObject {

    }

    @Definition("A mutable object with identity.")
    @Rule(
        "Entities must have identity-based equality." +
        "They must have one field that represents the id (atomic or composite) and must not be null." +
        "equals/hashCode must use only this field."
    )
    @Rule(
        "Entities must have the property of <i>identity stability<i>." +
        "The id must never change, which has business implications (can't use a person's name) and technical implications (can't generate the id on persistence)." +
        "Concretely, the id must be final."
    )
    @Guideline(
        "Entities should encapsulate state as much as possible." +
        "Behaviour, not data, should be exposed." +
        "eg. refactor conference.getParticipants.add(..) -> conference.addParticipant(..) -> conference.inscribe(..)"
    )
    public @interface Entity {
        Class<? extends AbstractAggregateRoot<?, ?>> aggregateRoot();
    }

    @Definition(
        "Entities should use specific Value Object identifiers." +
        "EntityId encapsulate the identity field creation rule, can enforce its format if user-provided, and are strongly typed (make explicit the type of Entity they identify)."
    )
    @Rule("Use ValueObjects to represent ids, not primitives.")
    @ValueObject
    public @interface EntityId {

    }

    @Definition("A particular Entity that represents the scope of coherent read and writes operations.")
    @Rule(
        "Cut the entities graph into aggregates. " +
        "Entities of different aggregates may not have reference to entities of another aggregate."
    )
    @Rule(
        "Entities of different aggregate may refer only to the root of another aggregate, and only by its id."
    )
    @Rule(
        "Aggregate boundaries must include all entities involved in invariants." +
        "eg. if Conference and Talk are involved in invariant {@code sum(conference.talks.cost) < conference.budget}, then Conference and Budget but be in the same aggregate."
    )
    @Rule(
        "Aggregates must remain small." +
        "This allows granular concurrency protection, and avoids <i>magical effects at a distance</i> with lazy loading, cascades, and so on."
    )
    @Rule(
        "If using the OptimistOfflineLock pattern, the version field must be on the AggregateRoot."
    )
    @Rule(
        "Update the version field manually if your persistence framework doesn't automatically detect changes to non-root entities (eg. with JPA, call {@code EntityManager.lock(aggregateRoot, OPTIMISTIC_FORCE_INCREMENT);})."
    )
    @Rule(
        "Don't write to more than one Aggregate instance in an ApplicationService (locks do not compose)."
    )
    @Rule(
        "You may read more than one Aggregate instance in an ApplicationService (in fact it is very common to do so)."
    )
    @Guideline(
        "Use other criteria to help find the correct boundary of aggregates." +
        "For instance if you do audit trail, and the BAs tell you that when entity B is modified that should be an audit line for entity A (which has a relation to B), then A is the AggregateRoot."
    )
    public @interface AggregateRoot {

    }

    @Definition(
        "A service that is reused across several features/ApplicationServices" +
        "Typical examples include complex validation, or stitching in-memory data from different sources."
    )
    public @interface DomainService {

    }

    @Definition("Signals significant transitions of domain state.")
    @Rule(
        "Name Domain Events with a past verbal form." +
        "Domain Events represent a fact that has already occurred (InvoiceSent, AccountActivated).")
    @Guideline(
        "Include enough relevant context." +
        "So that consumers of Domain Events can react to them, they should hold:" +
        "<ul>" +
        "<li>A technical event id to enable idempotent consumers" +
        "<li>The IDs of the changed AggregateRoot" +
        "<li>A timestamp" +
        "<li>(optional) enough before/after context to enable the consumer to react" +
        "</ul>"
    )
    public @interface DomainEvent {

    }

    @Definition(
        "Feature / business-transaction granularity service. " +
        "It represents business transactions exposed to the outside world (from the point of view of the current Bounded Context)." +
        "The operations it exposes are read and write transactional operations (so not resource-oriented/crud nor event-driven)."
    )
    @Rule(
        "Feature-specific / domain logic must not be implemented in the Exposition layer," +
        "as that leads to mixing business logic and technical preoccupations." +
        "It's best to have a separate application layer to represent the features outside of any technological consideration."
    )
    @Rule(
        "The ApplicationService must be a <i>boundary component</i>." +
        "It is a facade (like the GOF pattern) in front of the domain layer, and therefore is the scope of:" +
        "<ul>" +
        "<li>Transactions" +
        "<li>Authorization" +
        "<li>Validation" +
        "<li>Orchestration (coordinating calls to reusable types of the domain layer)" +
        "<li>..." +
        "/<ul>"
    )
    @Rule(
        "An ApplicationService may not call another ApplicationService." +
        "Unlike most kinds of services, ApplicationServices are not <i>self-composable</i> into coarser-grained ApplicationServices." +
        "That's because they explicitly represent feature-specific business logic. Rather extract a DomainService."
    )
    @Rule(
        "An Application Service must not write to more than one aggregate instance, but can read from more than one aggregate instance (@see the Aggregate {@code Rule}s)."
    )
    @Guideline(
        "DonAssemble complex view-specific data structures from the Application Service." +
        "When a feature needs data from several Aggregates, the required combined data is typically specific to that one feature. It is thus the ApplicationService’s responsibility to assemble this DataTransferObject."
    )
    @Guideline(
        "Favor task-based features over CRUD."
    )
    @Guideline(
        "When possible (almost always), it's better to implement these responsibilities in a declarative rather than imperative way."
    )
    @Guideline(
        "If the ApplicationService becomes too big, extract DomainServices even the extracted logic is feature-specific. " +
        "The extracted components will be much easier to test individually, can be given a meaningful name, and can be understood at a glance." +
        "When it's too big, it means it's not just doing orchestration, but implementing the whole business logic as a complex and non-reusable transaction script."
    )
    @Variation(
        "The names of ApplicationServices should be imperative verbal forms." +
        "ApplicationServices implement business transactions/actions. Therefore, their names should be a verb or (verb + noun). Ex: ScheduleConference, ViewConferenceDetails, ..."
    )
    public @interface ApplicationService {

    }

    @Definition("Represent data as a simple collection of elements")
    @Rule(
        "Restrict Repository semantics to collection methods + finders." +
        "The best way to ensure that the persistence layer doesn't include business logic is to restrict repositories to generic collection semantics (add/get/remove/clear/..) plus finders (findByName, ...)"
    )
    @Rule(
        "Repositories should participate in transactions, not initiate them." +
        "Defining the transaction granularity is the responsibility of the ApplicationService."
    )
    @Rule(
        "One Repository per-Aggregate, not per-Entity." +
        "The granularity of consistent reads and writes is the Aggregate."
    )
    @Variation(
        "Repositories with an 's'." +
        "I like naming Repositories the same as the AggregateRoot, pluralized. This reinforces the 'simple collection of elements' illusion"
    )
    public @interface Repository {

    }

    public @interface RepositoryImpl {

    }

    @Definition(
        "Represents a technical services more general than a Reposirory." +
        "ex: RestClient, CurrentUserSupplier, ..."
    )
    public @interface InfrastructureService {

    }

    public @interface InfrastructureServiceImpl {

    }

    //-----Descriptive annotations VVVVVVVVVVVVV-----
    @Documented @Retention(RUNTIME) @Target({ANNOTATION_TYPE, TYPE, FIELD})
    public @interface Definition {
        String value();
    }

    @Documented @Retention(RUNTIME) @Target({ANNOTATION_TYPE, TYPE, FIELD})
    @Repeatable(Rules.class)
    public @interface Rule {
        String value();
    }
    @Documented @Retention(RUNTIME) @Target({ANNOTATION_TYPE, TYPE, FIELD})
    public @interface Rules {
        Rule[] value();
    }

    @Documented @Retention(RUNTIME) @Target({ANNOTATION_TYPE, TYPE, FIELD})
    @Repeatable(Guidelines.class)
    public @interface Guideline {
        String value();
    }
    @Documented @Retention(RUNTIME) @Target({ANNOTATION_TYPE, TYPE, FIELD})
    public @interface Guidelines {
        Guideline[] value();
    }

    @Documented @Retention(RUNTIME) @Target({ANNOTATION_TYPE, TYPE, FIELD})
    @Repeatable(Variations.class)
    public @interface Variation {
        String value();
    }
    @Documented @Retention(RUNTIME) @Target({ANNOTATION_TYPE, TYPE, FIELD})
    public @interface Variations {
        Variation[] value();
    }
    //-----Descriptive annotations ^^^^^^^^^^^^^-----

}

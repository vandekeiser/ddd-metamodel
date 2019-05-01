package fr.cla.ddd.metamodel.appli;

import fr.cla.ddd.metamodel.domain.validation.InvalidObjectException;

import java.util.function.Function;

public class ApplicativeValidations {

    //TODO add slf4j to this module
    //private static final Logger log = LoggerFactory.getLogger(ApplicativeValidations.class);

    /**
     * @param <A> Type of application-level Command or Query
     * @param <D> Type of resulting domain-level Aggregate or Query
     * @return The domain-level object if valid
     * @throws InvalidCommandOrQueryException if the domain-level object would be invalid
     */
    public static <A, D> D validateApplicatively(
        A commandOrQuery, Function<A, D> toDomain
    ) throws InvalidCommandOrQueryException {
        D domainObject;
        try {
            domainObject = toDomain.apply(commandOrQuery);
        } catch (InvalidObjectException err) {
            //log.error("Invalid command {}", cmd);
            throw new InvalidCommandOrQueryException(err, commandOrQuery);
        }
        return domainObject;
    }

}

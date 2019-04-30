package fr.cla.ddd.metamodel.exampleapp.expo;

import fr.cla.ddd.metamodel.appli.InvalidCommandOrQueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Exception2HttpStatus extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(Exception2HttpStatus.class);

    @ExceptionHandler(value = InvalidCommandOrQueryException.class)
    protected ResponseEntity<Object> handleInvalidCommandOrQueryException(RuntimeException ex, WebRequest request) {
        log.info("Handling {}", ex.toString());
        String bodyOfResponse = ex.toString();

        return handleExceptionInternal(
            ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request
        );
    }

}

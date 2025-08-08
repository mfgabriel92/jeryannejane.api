package me.jeryannejane.api.api.exception;

import me.jeryannejane.api.domain.exception.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        var details = ExceptionResponse
            .builder()
            .status(NOT_FOUND)
            .message(ex.getMessage())
            .build();

        return new ResponseEntity<>(details, details.getStatus());
    }
}

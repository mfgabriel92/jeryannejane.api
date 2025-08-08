package me.jeryannejane.api.api.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ExceptionResponse {
    private HttpStatus status;

    private String message;
}
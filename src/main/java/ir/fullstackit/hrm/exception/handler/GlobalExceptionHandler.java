package ir.fullstackit.hrm.exception.handler;

import ir.fullstackit.hrm.exception.InvalidJsonException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = {"ir.fullstackit.hrm"})
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidJsonException.class)
    public void handleEmptyJsonObject(InvalidJsonException ex) {

    }
}

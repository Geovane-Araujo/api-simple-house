package com.adonai.simplehouse.excepitions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizeError extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BeanError.class)
    public final ResponseEntity<ExceptionResponse> handleError(BeanError e, WebRequest request){
            ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage(),request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.NOT_ACCEPTABLE);
    }
}


package com.tlu.chuyende.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = InvalidRequest.class)
    public ResponseEntity<?>handleInvalidRequest(InvalidRequest ex){
        return new ResponseEntity<>(ex.getError(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<?>handleNotFoundEx(NotFoundException ex){
        return new ResponseEntity<>(ex.getError(), HttpStatus.BAD_REQUEST);
    }
}

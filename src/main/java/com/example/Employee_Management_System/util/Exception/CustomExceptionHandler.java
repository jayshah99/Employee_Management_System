package com.example.Employee_Management_System.util.Exception;

import com.example.Employee_Management_System.Resources.pojo.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Response> handleInvalidRequest(MethodArgumentNotValidException ex) {

        return new ResponseEntity<>(
                new Response(true, ex.getBindingResult().getFieldError().getDefaultMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> handleInvalidRequest(NotFoundException ex) {
        return new ResponseEntity<>(
                new Response(true, ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

}

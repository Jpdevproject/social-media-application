package com.in28minutes.ranga.socialmediaapplication.users.exception;

import com.in28minutes.ranga.socialmediaapplication.users.ExceptionMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ExceptionMessage> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        ExceptionMessage exceptionMessage=new ExceptionMessage(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

     return new ResponseEntity<ExceptionMessage>(exceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionMessage> handleAllException(Exception ex, WebRequest request) throws Exception {
        ExceptionMessage exceptionMessage=new ExceptionMessage(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<ExceptionMessage>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ExceptionMessage exceptionMessage=new ExceptionMessage(LocalDateTime.now(), ex.getFieldErrors().stream().findAny().get().getDefaultMessage(), request.getDescription(false));
        return new ResponseEntity<Object>(exceptionMessage, HttpStatus.BAD_REQUEST);

    }
    }

package com.alvinmuniz.communallybackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler()
    public ResponseEntity<Object> handleSessionNotFoundException(
            SessionNotFoundException ex, WebRequest request ) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());

        return new ResponseEntity<> (body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler()
    public ResponseEntity<Object> handleContentNotFoundException(
            ContentNotFoundException ex, WebRequest request ) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());

        return new ResponseEntity<> (body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler()
    public ResponseEntity<Object> handleReflectionNotFoundException(
            ReflectionNotFoundException ex, WebRequest request ) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());

        return new ResponseEntity<> (body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler()
    public ResponseEntity<Object> handleUserNotFoundException(
            UserNotFoundException ex, WebRequest request ) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());

        return new ResponseEntity<> (body, HttpStatus.NOT_FOUND);
    }



}

package com.hunterkilltree.notification_system.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = { RuntimeException.class })

  ResponseEntity<String> handleRunTimeException(RuntimeException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }

  @ExceptionHandler(value = { MethodArgumentNotValidException.class })
  ResponseEntity<String> handleValidation(MethodArgumentNotValidException e) {
    return ResponseEntity.badRequest().body(e.getFieldError().getDefaultMessage());
  }

  
}

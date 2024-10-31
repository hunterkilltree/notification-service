package com.hunterkilltree.notification_system.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hunterkilltree.notification_system.dto.request.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = { RuntimeException.class })
  ResponseEntity<ApiResponse> handleRunTimeException(RuntimeException e) {
    // There is some case that we do not know
    ApiResponse response = new ApiResponse();
    response.setCode(ErrorCode.UNKNOWN_ERROR.getCode());
    response.setMessage(ErrorCode.UNKNOWN_ERROR.getMessage());
    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(value = { AppException.class })
  ResponseEntity<ApiResponse> handleAppException(AppException e) {
    ApiResponse response = new ApiResponse();
    response.setCode(e.getErrorCode().getCode());
    response.setMessage(e.getErrorCode().getMessage());
    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(value = { MethodArgumentNotValidException.class })
  ResponseEntity<ApiResponse> handleValidation(MethodArgumentNotValidException e) {
    // Because we can not set message as a ErrorCode, this is workaround solution
    String enumKey = e.getFieldError().getDefaultMessage();
    ErrorCode errorCode = ErrorCode.valueOf(enumKey);
    ApiResponse response = new ApiResponse();
    response.setCode(errorCode.getCode());
    response.setMessage(errorCode.getMessage());
    return ResponseEntity.badRequest().body(response);
  }
}

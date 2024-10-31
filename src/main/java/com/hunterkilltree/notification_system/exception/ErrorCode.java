package com.hunterkilltree.notification_system.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
  UNKNOWN_ERROR(999, "Unknown error"),
  USER_EXISTS(1001, "User already exists"),
  USER_PASSWORD_INVALID(1002, "Password must be at least 8 characters"),;
  
  private int code;
  private String message;

  ErrorCode(int code, String message) {
    this.code = code;
    this.message = message;
  }

}

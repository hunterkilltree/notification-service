package com.hunterkilltree.notification_system.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse <T> {
  private int code = 1000; // default success code 
  private String message;
  private T result;
  
}

package com.hunterkilltree.notification_system.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ApiResponse <T> {
  // Not add Builder.Default then using Builder to create instance the default value will be 0
  @Builder.Default
  int code = 1000; // default success code 
  String message;
  T result;
}

package com.hunterkilltree.notification_system.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreationRequest {
  private String username;

  @Size(min = 8, message = "USER_PASSWORD_INVALID")
  private String password;

  // private String email;
}

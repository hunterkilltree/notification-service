package com.hunterkilltree.notification_system.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreationRequest {
  private String username;

  @Size(min = 8, message = "Password must be at least 8 characters")
  private String password;

  // private String email;
}

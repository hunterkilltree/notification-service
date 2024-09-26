package com.hunterkilltree.notification_system.dto.request;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreationRequest {
  private String username;

  private String password;

  // private String email;
}

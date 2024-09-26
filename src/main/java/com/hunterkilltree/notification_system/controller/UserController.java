package com.hunterkilltree.notification_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.hunterkilltree.notification_system.dto.request.UserCreationRequest;
import com.hunterkilltree.notification_system.entity.User;
import com.hunterkilltree.notification_system.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
  @Autowired
  private UserService userService;

  // lưu ý user(s) đây là convention của việc đặt tên path cho API
  @PostMapping("/users")
  public User creteUser(@RequestBody UserCreationRequest request) {
      return userService.createUser(request);
  }
  
}

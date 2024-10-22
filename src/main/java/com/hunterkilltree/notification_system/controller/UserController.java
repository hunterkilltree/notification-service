package com.hunterkilltree.notification_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.hunterkilltree.notification_system.dto.request.UserCreationRequest;
import com.hunterkilltree.notification_system.dto.request.UserUpdateRequest;
import com.hunterkilltree.notification_system.entity.User;
import com.hunterkilltree.notification_system.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  // lưu ý user(s) đây là convention của việc đặt tên path cho API
  @PostMapping
  public User creteUser(@RequestBody UserCreationRequest request) {
      return userService.createUser(request);
  }
  
  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{userId}")
  public User getUser(@PathVariable String userId) {
    return userService.getUser(userId);
  }

  @PutMapping("/{userId}")
  public User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
    return userService.updateUser(userId, request);
  }
  
  @DeleteMapping("/{userId}")
  public void deleteUser(@PathVariable String userId) {
    userService.deleteUser(userId);
  }
}

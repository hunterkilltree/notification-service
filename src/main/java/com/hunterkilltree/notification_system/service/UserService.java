package com.hunterkilltree.notification_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunterkilltree.notification_system.dto.request.UserCreationRequest;
import com.hunterkilltree.notification_system.dto.request.UserUpdateRequest;
import com.hunterkilltree.notification_system.entity.User;
import com.hunterkilltree.notification_system.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User createUser(UserCreationRequest request) {
    User user = new User();
    user.setUsername(request.getUsername());
    user.setPassword(request.getPassword());
    // user.setEmail(request.getEmail());
    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUser(String id) {
    return userRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("User not found"));
  }

  public User updateUser(String id, UserUpdateRequest request) {
    User user = getUser(id);

    user.setPassword(request.getPassword());
    return userRepository.save(user);
  }

  public void deleteUser(String id) {
    userRepository.deleteById(id);
  }
}

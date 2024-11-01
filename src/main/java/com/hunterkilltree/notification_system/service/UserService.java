package com.hunterkilltree.notification_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunterkilltree.notification_system.dto.request.UserCreationRequest;
import com.hunterkilltree.notification_system.dto.request.UserUpdateRequest;
import com.hunterkilltree.notification_system.dto.response.UserResponse;
import com.hunterkilltree.notification_system.entity.User;
import com.hunterkilltree.notification_system.exception.AppException;
import com.hunterkilltree.notification_system.exception.ErrorCode;
import com.hunterkilltree.notification_system.mapper.UserMapper;
import com.hunterkilltree.notification_system.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
  UserRepository userRepository;
  UserMapper userMapper;

  public UserResponse createUser(UserCreationRequest request) {
    if (userRepository.existsByUsername(request.getUsername())) {
      throw new AppException(ErrorCode.USER_EXISTS);
    }

    User user = userMapper.toUser(request);
    return userMapper.toUserResponse(userRepository.save(user));
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

    userMapper.updateUser(user, request);
    user.setPassword(request.getPassword());
    return userRepository.save(user);
  }

  public void deleteUser(String id) {
    userRepository.deleteById(id);
  }
}

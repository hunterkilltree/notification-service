package com.hunterkilltree.notification_system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.hunterkilltree.notification_system.dto.request.UserCreationRequest;
import com.hunterkilltree.notification_system.dto.request.UserUpdateRequest;
import com.hunterkilltree.notification_system.dto.response.UserResponse;
import com.hunterkilltree.notification_system.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
  User toUser(UserCreationRequest request);
  User updateUser(@MappingTarget User user, UserUpdateRequest request);
  UserResponse toUserResponse(User user);
}

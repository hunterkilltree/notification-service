package com.hunterkilltree.notification_system.mapper;

import org.mapstruct.Mapper;

import com.hunterkilltree.notification_system.dto.request.UserCreationRequest;
import com.hunterkilltree.notification_system.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
  User toUser(UserCreationRequest request);
}

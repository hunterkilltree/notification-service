package com.hunterkilltree.notification_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hunterkilltree.notification_system.entity.User;

// Theo cái multi layer của spring ở mỗi request chúng ta sẽ đi qua ít nhất 3 layers
// 1. Controller: Quản lý mapping  endpoint
// 2. Service: nơi xử lý logic liên quan
// 3. Repository: nơi tương tác trực tiếp với dbms, kết nối với hệ thống bên ngoài để lưu trữ
@Repository
public interface UserRepository extends JpaRepository<User, String> {

}

package com.tttnbackend.tttnbackend.repository;

import com.tttnbackend.tttnbackend.entity.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {
}

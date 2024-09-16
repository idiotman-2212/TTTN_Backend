package com.tttnbackend.tttnbackend.repository;

import com.tttnbackend.tttnbackend.entity.Role;
import com.tttnbackend.tttnbackend.entity.enumType.RoleCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleCode(RoleCode roleCode);
}

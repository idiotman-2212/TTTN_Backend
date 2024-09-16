package com.tttnbackend.tttnbackend.sevice;

import com.tttnbackend.tttnbackend.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(Long id);

    Role update(Role role);

}

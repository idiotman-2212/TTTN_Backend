package com.tttnbackend.tttnbackend.sevice.Impl;

import com.tttnbackend.tttnbackend.entity.Role;
import com.tttnbackend.tttnbackend.repository.RoleRepository;
import com.tttnbackend.tttnbackend.sevice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    @Override
    public Role update(Role role) {
        return null;
    }
}

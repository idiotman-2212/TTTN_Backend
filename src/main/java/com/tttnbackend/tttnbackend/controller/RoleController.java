package com.tttnbackend.tttnbackend.controller;

import com.tttnbackend.tttnbackend.entity.Role;
import com.tttnbackend.tttnbackend.sevice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    public List<Role> getAll (){
        return roleService.findAll();
    }
}

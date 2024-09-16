package com.tttnbackend.tttnbackend.sevice;

import com.tttnbackend.tttnbackend.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByUsername(String username);
    User save(User user);
    User update(User user);
    String delete(String username);
    Boolean checkDuplicateUserInfo(String mode, String username, String field, String value);
}

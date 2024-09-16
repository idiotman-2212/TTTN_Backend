package com.tttnbackend.tttnbackend.sevice.Impl;

import com.tttnbackend.tttnbackend.entity.User;
import com.tttnbackend.tttnbackend.exception.ExistingResourceException;
import com.tttnbackend.tttnbackend.exception.ResourceNotFoundException;
import com.tttnbackend.tttnbackend.repository.UserRepository;
import com.tttnbackend.tttnbackend.repository.UtilRepository;
import com.tttnbackend.tttnbackend.sevice.UserService;
import com.tttnbackend.tttnbackend.validator.ObjectValidator;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    ObjectValidator<User> userValidator;
    private final UtilRepository utilRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()-> new ResourceNotFoundException("Not found User <%s>".formatted(username)));
    }

    @Override
    public User save(User user) {
        userValidator.validate(user);
        if(!checkDuplicateUserInfo("ADD", user.getUsername(), "username", user.getUsername())){
            throw new ExistingResourceException("Username " + user.getUsername() +" is already exist");
        }
        if(!checkDuplicateUserInfo("ADD", user.getUsername(), "email", user.getEmail())){
            throw new ExistingResourceException("Email "  + user.getEmail() + " is already exist");
        }

        if(!checkDuplicateUserInfo("ADD", user.getUsername(), "phone", user.getPhone())){
            throw new ExistingResourceException("Phone " + user.getPhone() + " is already exist");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        userValidator.validate(user);
        if(!checkDuplicateUserInfo("EDIT", user.getUsername(), "username", user.getUsername())){
            throw new ExistingResourceException("Username " + user.getUsername() + " is already exist");
        }
        if(!checkDuplicateUserInfo("EDIT", user.getUsername(), "email", user.getEmail())){
            throw new ExistingResourceException("Email "+ user.getEmail() + " is already exist");
        }
        if(!checkDuplicateUserInfo("EDIT", user.getPhone(), "phone",  user.getPhone()));

        return userRepository.save(user);
    }

    @Override
    public String delete(String username) {

        return userRepository.deleteUserByUsername(username);
    }

    //kiểm tra true thì không trùng, false thì trùng
    @Override
    public Boolean checkDuplicateUserInfo(String mode, String username, String field, String value) {
    List<User> foundUsers = utilRepository.checkDuplicateByStringField(User.class, mode, "username", username, field, value);
        return foundUsers.isEmpty();
    }

}

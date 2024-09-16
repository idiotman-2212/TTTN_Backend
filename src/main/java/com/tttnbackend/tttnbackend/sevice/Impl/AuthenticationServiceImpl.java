package com.tttnbackend.tttnbackend.sevice.Impl;

import com.tttnbackend.tttnbackend.dto.AuthenticationRequest;
import com.tttnbackend.tttnbackend.dto.AuthenticationResponse;
import com.tttnbackend.tttnbackend.dto.RegisterRequest;
import com.tttnbackend.tttnbackend.entity.Role;
import com.tttnbackend.tttnbackend.entity.User;
import com.tttnbackend.tttnbackend.exception.ExistingResourceException;
import com.tttnbackend.tttnbackend.exception.ResourceNotFoundException;
import com.tttnbackend.tttnbackend.jwt.JwtService;
import com.tttnbackend.tttnbackend.repository.RoleRepository;
import com.tttnbackend.tttnbackend.repository.UserRepository;
import com.tttnbackend.tttnbackend.sevice.AuthenticationService;
import com.tttnbackend.tttnbackend.sevice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken( authenticationRequest.getUsername(), authenticationRequest.getPassword()));
    if(authentication.isAuthenticated()){
        User user = userService.findByUsername(authenticationRequest.getUsername());
        String jwtToken = jwtService.generateToken(user);


        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }else throw new ResourceNotFoundException("Invalid Request");
    }

    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        if(userRepository.existsByUsername(registerRequest.getUsername())){
            throw new ExistingResourceException("Username already exist");
        }
        if(userRepository.existsByPhone(registerRequest.getPhone())){
            throw new ExistingResourceException("Phone already exist");
        }
        if(userRepository.existsByEmail(registerRequest.getEmail())){
            throw new ExistingResourceException("Email already exist");
        }
        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .username(registerRequest.getUsername())
                .phone(registerRequest.getPhone())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .active(true)
                .gender(false)
                .build();

        Role role = roleRepository.findByRoleCode(registerRequest.getRoles()).get();

        User createUser = userService.save(user);
        String jwtToken = jwtService.generateToken(createUser);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}

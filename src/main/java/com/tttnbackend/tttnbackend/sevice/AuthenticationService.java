package com.tttnbackend.tttnbackend.sevice;

import com.tttnbackend.tttnbackend.dto.AuthenticationRequest;
import com.tttnbackend.tttnbackend.dto.AuthenticationResponse;
import com.tttnbackend.tttnbackend.dto.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);

    AuthenticationResponse register(RegisterRequest registerRequest);

}

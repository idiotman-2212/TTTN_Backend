package com.tttnbackend.tttnbackend.dto;

import com.tttnbackend.tttnbackend.entity.enumType.RoleCode;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class RegisterRequest {
    String firstName;
    String lastName;
    String phone;
    String username;
    String email;
    String password;
    RoleCode roles;

}

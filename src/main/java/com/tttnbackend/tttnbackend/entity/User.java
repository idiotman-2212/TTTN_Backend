package com.tttnbackend.tttnbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal=false)
public class User implements UserDetails {
    @Id
    String username;

    @NotEmpty(message = "Password should not be empty")
    String password;

    @NotEmpty(message = "First name should not be empty")
    String firstName;

    @NotEmpty(message = "Last name should not be empty")
    String lastName;

    @Column(unique = true)
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]" +
            "+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Invalid email")
//    @Pattern(regexp = AppConstants.EMAIL_REGEX_PATTERN, message = "Invalid email")
    String email;

    @Column(unique = true)
    @Pattern(regexp = "^(0|84)[0-9]{9}$", message = "Invalid phone")
//  @Pattern(regexp = AppConstants.PHONE_REGEX_PATTERN, message = "Invalid phone")
    String phone;
    String address;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;

    Boolean gender;

    Boolean active;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<UserPermission> userPermissions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    @JsonIgnore
    List<Token> tokens;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    List<Booking> bookings;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userPermissions.stream()
                .map(userPermission -> new SimpleGrantedAuthority(userPermission.getRole().getRoleName()))
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

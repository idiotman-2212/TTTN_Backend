package com.tttnbackend.tttnbackend.entity;

import com.tttnbackend.tttnbackend.entity.enumType.TokenType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    TokenType tokenType;

    String token;
    boolean expired;
    boolean revoked;

    @ManyToOne
    @JoinColumn(name = "username")
    User user;
}

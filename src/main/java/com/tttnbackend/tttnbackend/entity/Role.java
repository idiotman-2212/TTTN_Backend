package com.tttnbackend.tttnbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tttnbackend.tttnbackend.entity.enumType.RoleCode;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    RoleCode roleCode;

    String roleName;

    String description;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    Set<UserPermission> userPermissions;
}

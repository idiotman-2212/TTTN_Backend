package com.tttnbackend.tttnbackend.entity;

import com.tttnbackend.tttnbackend.entity.enumType.CoachType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String name;

    int capacity;

    @Column(unique = true)
    String licensePlate;

    @Enumerated(EnumType.STRING)
    CoachType coachType;

    @OneToMany(mappedBy = "coach")
    List<Trip> trips;
}

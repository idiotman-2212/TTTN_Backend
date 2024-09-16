package com.tttnbackend.tttnbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String codeName;

    @OneToMany(mappedBy = "source")
            @JsonIgnore
    List<Trip> sourceTrips;

    @OneToMany(mappedBy = "destination")
            @JsonIgnore
    List<Trip> destTrips;
}

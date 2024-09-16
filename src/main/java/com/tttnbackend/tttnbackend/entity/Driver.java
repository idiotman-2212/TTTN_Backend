package com.tttnbackend.tttnbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;
    String lastName;

    @Column(unique = true)
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]" +
            "+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Invalid email")
    String email;

    @Column(unique = true)
    @Pattern(regexp = "^(0|84)[0-9]{9}$", message = "Invalid phone")
    String phone;

    @Column(unique = true)
    String licenseNumber;
    String address;
    LocalDate dob;
    boolean gender;
    boolean quit;

    @OneToMany(mappedBy = "driver")
    List<Trip> trips;

    public String getFullName(){
        return this.getFirstName().concat(" ").concat(this.getLastName());
    }
}

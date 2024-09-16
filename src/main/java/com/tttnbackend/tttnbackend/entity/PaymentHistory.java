package com.tttnbackend.tttnbackend.entity;

import com.tttnbackend.tttnbackend.entity.enumType.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    Booking booking;

    LocalDateTime statusChangeDateTime;

    @Enumerated(EnumType.STRING)
    PaymentStatus oldStatus;

    @Enumerated(EnumType.STRING)
    PaymentStatus newStatus;

}

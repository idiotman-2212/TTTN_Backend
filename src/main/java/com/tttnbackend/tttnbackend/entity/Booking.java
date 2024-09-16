package com.tttnbackend.tttnbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tttnbackend.tttnbackend.entity.enumType.BookingType;
import com.tttnbackend.tttnbackend.entity.enumType.PaymentMethod;
import com.tttnbackend.tttnbackend.entity.enumType.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    Trip trip;

    @Enumerated(EnumType.STRING)
    BookingType bookingType;

    @ManyToOne
    @JoinColumn(name = "username")
    User user;

    String seatNumber;

    String pickUpAddress;
    String custFirstName;
    String custLastName;

    @Pattern(regexp = "^(0|84)[0-9]{9}$", message = "Invalid phone")
    String phone;

    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]" +
            "+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Invalid email")
    String email;

    BigDecimal totalPayment;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime paymentDateTime;

    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    PaymentStatus paymentStatus;

    @OneToMany(mappedBy = "booking")
    List<PaymentHistory> paymentHistories;

}

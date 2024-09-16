package com.tttnbackend.tttnbackend.dto;

import com.tttnbackend.tttnbackend.entity.Trip;
import com.tttnbackend.tttnbackend.entity.User;
import com.tttnbackend.tttnbackend.entity.enumType.BookingType;
import com.tttnbackend.tttnbackend.entity.enumType.PaymentMethod;
import com.tttnbackend.tttnbackend.entity.enumType.PaymentStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class BookingRequest {
    Long id;
    User user;
    Trip trip;
    LocalDateTime bookingDateTime;
    BookingType bookingType;
    String[] seatNumber;
    String pickUpAddress;
    String firstName;
    String lastName;
    String phone;
    String email;
    BigDecimal totalPayment;
    LocalDateTime paymentDateTime;
    PaymentMethod paymentMethod;
    PaymentStatus paymentStatus;
}

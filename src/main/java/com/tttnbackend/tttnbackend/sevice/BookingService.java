package com.tttnbackend.tttnbackend.sevice;

import com.tttnbackend.tttnbackend.dto.BookingRequest;
import com.tttnbackend.tttnbackend.entity.Booking;
import com.tttnbackend.tttnbackend.entity.User;

import java.util.List;

public interface BookingService {
    List<Booking> findAll();
    Booking findById(Long id);
    List<Booking> findAllByPhone(String phone);
    List<Booking> findAllByUsername(String username);
    List<Booking> save(BookingRequest bookingRequest);
    Booking update(Booking booking);
    String delete(Long id);
}

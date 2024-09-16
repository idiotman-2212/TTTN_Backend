package com.tttnbackend.tttnbackend.repository;

import com.tttnbackend.tttnbackend.entity.Booking;
import com.tttnbackend.tttnbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByPhone(String phone);

    List<Booking> findAllByUser(User user);
}

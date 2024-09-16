package com.tttnbackend.tttnbackend.sevice;

import com.tttnbackend.tttnbackend.entity.Trip;

import java.util.List;

public interface TripService {
    List<Trip> findAll();
    Trip findById (Long id);
    Trip save(Trip trip);
    Trip update(Trip trip);
    String deleteById(Long id);
}

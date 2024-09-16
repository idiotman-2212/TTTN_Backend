package com.tttnbackend.tttnbackend.repository;

import com.tttnbackend.tttnbackend.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}

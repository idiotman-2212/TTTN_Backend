package com.tttnbackend.tttnbackend.repository;

import com.tttnbackend.tttnbackend.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    boolean existsById(Long id);
}

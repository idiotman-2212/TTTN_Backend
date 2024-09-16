package com.tttnbackend.tttnbackend.sevice;

import com.tttnbackend.tttnbackend.entity.Driver;

import java.util.List;

public interface DriverService {
    Driver findById(Long id);
    List<Driver> findAll();
    Driver save(Driver driver);
    Driver update(Driver driver);
    String delete(Long id);
    Boolean checkDuplicateDriverInfo(String mode, Object driverId, String field, String value);
}

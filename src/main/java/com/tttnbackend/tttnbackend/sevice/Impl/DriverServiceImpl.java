package com.tttnbackend.tttnbackend.sevice.Impl;

import com.tttnbackend.tttnbackend.entity.Driver;
import com.tttnbackend.tttnbackend.exception.ExistingResourceException;
import com.tttnbackend.tttnbackend.exception.ResourceNotFoundException;
import com.tttnbackend.tttnbackend.repository.DriverRepository;
import com.tttnbackend.tttnbackend.repository.UtilRepository;
import com.tttnbackend.tttnbackend.sevice.DriverService;
import com.tttnbackend.tttnbackend.validator.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final ObjectValidator<Driver> driverObjectValidator;
    private final UtilRepository utilRepository;

    @Override
    public Driver findById(Long id) {
        return driverRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Driver is invalid"));
    }

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @Override
    public Driver save(Driver driver) {
        driverObjectValidator.validate(driver);
        if(!checkDuplicateDriverInfo("ADD", driver.getId(), "email", driver.getEmail())){
            throw new ExistingResourceException("Email " + driver.getEmail() + "is already exist");
        }
        if (!checkDuplicateDriverInfo("ADD", driver.getId(), "phone", driver.getPhone())){
            throw new ExistingResourceException("Phone " + driver.getPhone() + " is already exist");
        }
        if(!checkDuplicateDriverInfo("ADD", driver.getId(), "licenseNumber", driver.getLicenseNumber())){
            throw new ExistingResourceException("LicenseNumber " + driver.getLicenseNumber() + " is already exist");
        }
        return driverRepository.save(driver);
    }

    @Override
    public Driver update(Driver driver) {
        driverObjectValidator.validate(driver);
        if(!checkDuplicateDriverInfo("EDIT", driver.getId(), "email", driver.getEmail())){
            throw new ExistingResourceException("Email " + driver.getEmail() + " is already exist");
        }
        if (!checkDuplicateDriverInfo("EDIT", driver.getId(), "phone", driver.getPhone())){
            throw new ExistingResourceException("Phone " + driver.getPhone() + " is already exist");
        }
        if(!checkDuplicateDriverInfo("EDIT", driver.getId(), "licenseNumber", driver.getLicenseNumber())){
            throw new ExistingResourceException("LicenseNumber " + driver.getLicenseNumber() + " is already exist");
        }
        return driverRepository.save(driver);
    }

    @Override
    public String delete(Long id) {
        if(driverRepository.existsById(id)){
            driverRepository.deleteById(id);
            return "Delete driver success";
        }else{
            return "Driver not exist";
        }
    }

    @Override
    public Boolean checkDuplicateDriverInfo(String mode, Object driverId, String field, String value) {
        List<Driver> foundDriver = utilRepository.checkDuplicateByStringField(Driver.class, mode, "id", driverId, field, value);
        return foundDriver.isEmpty();
    }


}

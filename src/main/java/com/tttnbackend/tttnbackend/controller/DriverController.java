package com.tttnbackend.tttnbackend.controller;

import com.tttnbackend.tttnbackend.entity.Driver;
import com.tttnbackend.tttnbackend.sevice.DriverService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/drivers")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class DriverController {
    private final DriverService driverService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(driverService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(driverService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Driver driver){
        return ResponseEntity.ok(driverService.save(driver));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Driver driver){
        return ResponseEntity.ok(driverService.save(driver));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(driverService.delete(id));
    }
}

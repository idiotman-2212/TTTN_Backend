package com.tttnbackend.tttnbackend.controller;

import com.tttnbackend.tttnbackend.entity.Trip;
import com.tttnbackend.tttnbackend.sevice.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trips")
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(tripService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(tripService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Trip trip){
        return ResponseEntity.ok(tripService.save(trip));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Trip trip){
        return ResponseEntity.ok(tripService.save(trip));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(tripService.deleteById(id));
    }

}

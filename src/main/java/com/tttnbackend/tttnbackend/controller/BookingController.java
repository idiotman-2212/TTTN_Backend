package com.tttnbackend.tttnbackend.controller;

import com.tttnbackend.tttnbackend.dto.BookingRequest;
import com.tttnbackend.tttnbackend.entity.User;
import com.tttnbackend.tttnbackend.sevice.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookngs")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(bookingService.findAll());
    }

    @GetMapping("/all/{phone}")
    public ResponseEntity<?> findAllByPhone(@PathVariable String phone){
        return ResponseEntity.ok(bookingService.findAllByPhone(phone));
    }

    @GetMapping("/all/user/{username}")
    public ResponseEntity<?> findAllByUsername(@PathVariable String username){
        return ResponseEntity.ok(bookingService.findAllByUsername(username));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(bookingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BookingRequest bookingRequest){
        return ResponseEntity.ok(bookingService.save(bookingRequest));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody BookingRequest bookingRequest){
        return ResponseEntity.ok(bookingService.save(bookingRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(bookingService.delete(id));
    }
}

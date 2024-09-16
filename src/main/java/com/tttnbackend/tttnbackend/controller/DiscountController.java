package com.tttnbackend.tttnbackend.controller;

import com.tttnbackend.tttnbackend.entity.Discount;
import com.tttnbackend.tttnbackend.sevice.DiscountService;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/discounts")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(discountService.findAll());
    }

    @GetMapping("/available")
    public ResponseEntity<?> getAllAvailable(){
        return ResponseEntity.ok(discountService.findAllAvailable());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(discountService.findById(id));
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> findByCode(@PathVariable String code){
        return ResponseEntity.ok(discountService.findByCode(code));
    }

    @PostMapping
    public ResponseEntity<?> createDiscount(@RequestBody Discount discount){
        return ResponseEntity.ok(discountService.save(discount));
    }

    @PutMapping
    public ResponseEntity<?> updateDiscount(@RequestBody Discount discount){
        return ResponseEntity.ok(discountService.update(discount));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(discountService.deleteById(id));
    }
}

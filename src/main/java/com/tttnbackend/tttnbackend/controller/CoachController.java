package com.tttnbackend.tttnbackend.controller;

import com.tttnbackend.tttnbackend.entity.Coach;
import com.tttnbackend.tttnbackend.sevice.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coaches")
@RequiredArgsConstructor
public class CoachController {
    private final CoachService coachService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(coachService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(coachService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Coach coach){
        return ResponseEntity.ok(coachService.save(coach));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Coach coach){
        return ResponseEntity.ok(coachService.save(coach));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(coachService.deleteById(id));
    }


}

package com.tttnbackend.tttnbackend.sevice;

import com.tttnbackend.tttnbackend.entity.Coach;

import java.util.List;

public interface CoachService {
    List<Coach> findAll();
    Coach findById(Long id);
    Coach save(Coach coach);
    Coach update(Coach coach);
    String deleteById(Long id);
    boolean checkDuplicateCoachInfo(String mode, Long coachId, String field, String value);
}

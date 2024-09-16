package com.tttnbackend.tttnbackend.sevice.Impl;

import com.tttnbackend.tttnbackend.entity.Coach;
import com.tttnbackend.tttnbackend.exception.ResourceNotFoundException;
import com.tttnbackend.tttnbackend.repository.CoachRepository;
import com.tttnbackend.tttnbackend.repository.UtilRepository;
import com.tttnbackend.tttnbackend.sevice.CoachService;
import com.tttnbackend.tttnbackend.validator.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;
    private final UtilRepository utilRepository;
    private final ObjectValidator<Coach> coachObjectValidator;

    @Override
    public List<Coach> findAll() {
        return coachRepository.findAll();
    }

    @Override
    public Coach findById(Long id) {
        return coachRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Coach not found"));
    }

    @Override
    public Coach save(Coach coach) {
        coachObjectValidator.validate(coach);
        if(!checkDuplicateCoachInfo("ADD", coach.getId(), "name", coach.getName())){
            throw  new ResourceNotFoundException("Coach name " + coach.getName() + " is already exist");
        }
        if(!checkDuplicateCoachInfo("ADD", coach.getId(), "licensePlate", coach.getLicensePlate())){
            throw  new ResourceNotFoundException("License plate " + coach.getLicensePlate() + " is already exist");
        }
        return coachRepository.save(coach);
    }

    @Override
    public Coach update(Coach coach) {
        if(!checkDuplicateCoachInfo("EDIT", coach.getId(), "name", coach.getName())){
            throw  new ResourceNotFoundException("Coach name " + coach.getName() + " is already exist");
        }
        if(!checkDuplicateCoachInfo("EDIT", coach.getId(), "licensePlate", coach.getLicensePlate())){
            throw  new ResourceNotFoundException("License plate " + coach.getLicensePlate() + " is already exist");
        }
        return coachRepository.save(coach);
    }

    @Override
    public String deleteById(Long id) {
        if(coachRepository.existsById(id)){
            coachRepository.deleteById(id);
            return "Coach delete success";
        }else{
            return "Not found coach";
        }

    }

    @Override
    public boolean checkDuplicateCoachInfo(String mode, Long coachId, String field, String value) {
        List<Coach> foundCoach = utilRepository.checkDuplicateByStringField(Coach.class, mode,"id", coachId, field, value);
        return foundCoach.isEmpty();
    }
}

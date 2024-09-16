package com.tttnbackend.tttnbackend.sevice.Impl;

import com.tttnbackend.tttnbackend.entity.Trip;
import com.tttnbackend.tttnbackend.exception.ResourceNotFoundException;
import com.tttnbackend.tttnbackend.repository.TripRepository;
import com.tttnbackend.tttnbackend.sevice.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;
    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public Trip findById(Long id) {
        return tripRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found trip"));
    }

    @Override
    public Trip save(Trip trip) {

        return tripRepository.save(trip);
    }

    @Override
    public Trip update(Trip trip) {

        return tripRepository.save(trip);
    }

    @Override
    public String deleteById(Long id) {
        if(tripRepository.existsById(id)){
            tripRepository.deleteById(id);
            return "Deleted trip success";
        }else{
            return "Not found trip";
        }

    }
}

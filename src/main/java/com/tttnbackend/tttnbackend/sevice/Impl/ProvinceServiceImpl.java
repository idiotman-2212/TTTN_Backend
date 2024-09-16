package com.tttnbackend.tttnbackend.sevice.Impl;

import com.tttnbackend.tttnbackend.entity.Province;
import com.tttnbackend.tttnbackend.exception.ResourceNotFoundException;
import com.tttnbackend.tttnbackend.repository.ProvinceRepository;
import com.tttnbackend.tttnbackend.sevice.ProvinceSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceSevice {
    private final ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Province not found"));
    }

    @Override
    public Province findByCodeName(String codeName) {
        return provinceRepository.findByCodeName(codeName);
    }
}

package com.tttnbackend.tttnbackend.sevice;

import com.tttnbackend.tttnbackend.entity.Province;

import java.util.List;
import java.util.Optional;

public interface ProvinceSevice {
    List<Province> findAll();
    Province findById(Long id);
    Province findByCodeName(String codeName);
}

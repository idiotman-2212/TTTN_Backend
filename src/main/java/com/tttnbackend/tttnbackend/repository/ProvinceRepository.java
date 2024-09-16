package com.tttnbackend.tttnbackend.repository;

import com.tttnbackend.tttnbackend.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Province findByCodeName(String codeName);
}

package com.tttnbackend.tttnbackend.repository;

import com.tttnbackend.tttnbackend.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
}

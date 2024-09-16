package com.tttnbackend.tttnbackend.repository;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.tttnbackend.tttnbackend.entity.Discount;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {

    Optional<Discount> findByCode(String codeName);

@Query("select d from Discount d where current_date < d.endDateTime")
    List<Discount> findAllAvailable();

boolean existsById(Long id);
}

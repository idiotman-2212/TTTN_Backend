package com.tttnbackend.tttnbackend.sevice;

import com.tttnbackend.tttnbackend.entity.Discount;

import java.util.List;
import java.util.Optional;

public interface DiscountService {
    List<Discount> findAll();
    Discount save(Discount discount);
    Discount findById(Long id);
    Discount findByCode(String code);
    List<Discount> findAllAvailable();
    Discount update(Discount discount);
    String deleteById(Long id);
    boolean checkDuplicateDiscountInfo(String mode, Long discountId, String field, String value);
}

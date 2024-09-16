package com.tttnbackend.tttnbackend.sevice.Impl;

import com.tttnbackend.tttnbackend.entity.Discount;
import com.tttnbackend.tttnbackend.exception.ExistingResourceException;
import com.tttnbackend.tttnbackend.exception.ResourceNotFoundException;
import com.tttnbackend.tttnbackend.repository.DiscountRepository;
import com.tttnbackend.tttnbackend.repository.UtilRepository;
import com.tttnbackend.tttnbackend.sevice.DiscountService;
import com.tttnbackend.tttnbackend.validator.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;
    private final ObjectValidator<Discount> discountObjectValidator;
    private final UtilRepository utilRepository;

    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public Discount save(Discount discount) {
discountObjectValidator.validate(discount);
if(!checkDuplicateDiscountInfo("ADD", discount.getId(), "code", discount.getCode())){
    throw new ExistingResourceException("Code " + discount.getCode() + " is already exist");
}
        if(discount.getStartDateTime().isAfter(discount.getEndDateTime())){
            throw new ResourceNotFoundException("Invalid: START DATE is after END DATE!");
        }
        return discountRepository.save(discount);
    }

    @Override
    public Discount findById(Long id) {
        return discountRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Discount not found"));
    }

    @Override
    public Discount findByCode(String code) {
        return discountRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Not found discount code"));
    }

    @Override
    public List<Discount> findAllAvailable() {
        return discountRepository.findAllAvailable();
    }

    @Override
    public Discount update(Discount discount) {
        discountObjectValidator.validate(discount);
        if(!checkDuplicateDiscountInfo("EDIT", discount.getId(), "code", discount.getCode())){
            throw new ExistingResourceException("Code " + discount.getCode() + " is already exist");
        }
        if(discount.getStartDateTime().isAfter(discount.getEndDateTime())){
            throw new ResourceNotFoundException("Invalid: START DATE is after END DATE!");
        }
        return discountRepository.save(discount);
    }

    @Override
    public String deleteById(Long id) {
        if(discountRepository.existsById(id)){
            discountRepository.deleteById(id);
            return "Discount deleted success";
        }
        else{
            return "Discount not found";
        }
    }

    @Override
    public boolean checkDuplicateDiscountInfo(String mode, Long discountId, String field, String value) {
        List<Discount> foundDiscount = utilRepository.checkDuplicateByStringField(Discount.class, mode, "id", discountId, field, value);
        return foundDiscount.isEmpty();
    }
}

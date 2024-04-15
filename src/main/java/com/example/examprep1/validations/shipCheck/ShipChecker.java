package com.example.examprep1.validations.shipCheck;

import com.example.examprep1.repositories.ShipRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ShipChecker implements ConstraintValidator<ShipCheck, String> {

    private final ShipRepository shipRepository;

    public ShipChecker(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }


    @Override
    public void initialize(ShipCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String shipName, ConstraintValidatorContext constraintValidatorContext) {
        return shipRepository.findByName(shipName).isPresent();
    }

}

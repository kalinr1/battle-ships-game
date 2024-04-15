package com.example.examprep1.validations.availableShipNameCheck;

import com.example.examprep1.repositories.ShipRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AvailableShipNameChecker implements ConstraintValidator<AvailableShipNameCheck, String> {

    private final ShipRepository shipRepository;

    public AvailableShipNameChecker(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }


    @Override
    public void initialize(AvailableShipNameCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String shipName, ConstraintValidatorContext constraintValidatorContext) {
        return shipRepository.findByName(shipName).isEmpty();
    }

}

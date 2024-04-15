package com.example.examprep1.validations.availableEmailCheck;

import com.example.examprep1.repositories.UserRepository;
import com.example.examprep1.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AvailableEmailChecker implements ConstraintValidator<AvailableEmailCheck, String> {

    private final UserRepository userRepository;

    public AvailableEmailChecker(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(AvailableEmailCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.findByEmail(email).isEmpty();
    }

}

package com.example.examprep1.validations.validateUserLoginDTO;

import com.example.examprep1.models.dtoS.binding.UserLoginDTO;
import com.example.examprep1.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserLoginValidator implements ConstraintValidator<UserLoginValidate, UserLoginDTO> {

    private final UserRepository userRepository;

    public UserLoginValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UserLoginValidate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginDTO userLoginDTO, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.findByUsernameAndPassword(userLoginDTO.getUsername(), userLoginDTO.getPassword()).isPresent();
    }
}

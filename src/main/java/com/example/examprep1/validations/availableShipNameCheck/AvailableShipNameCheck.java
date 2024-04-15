package com.example.examprep1.validations.availableShipNameCheck;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AvailableShipNameChecker.class)
public @interface AvailableShipNameCheck {
    String message() default "Ship is already registered";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

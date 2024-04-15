package com.example.examprep1.validations.shipCheck;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ShipChecker.class)
public @interface ShipCheck {
    String message() default "No ship with such name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

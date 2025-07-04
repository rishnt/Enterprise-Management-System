package com.rishant.Enterprise.Management.System.DataValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StudentAddressValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)

public @interface StudentAddressValidation {
    String message() default "the Address Is Not Valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

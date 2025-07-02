package com.rishant.Enterprise.Management.System.DataValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SchoolNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SchoolNameValidation {
    String message() default "THE SCHOOL NAME DOES NOT EXIST";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

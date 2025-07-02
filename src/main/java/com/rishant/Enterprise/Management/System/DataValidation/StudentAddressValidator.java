package com.rishant.Enterprise.Management.System.DataValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.Locale;

public class StudentAddressValidator implements ConstraintValidator<StudentAddressValidation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<String> addresses = List.of(
                "Shakun Nagar",
                "Kandawapokhra",
                "vinayakpuram",
                "Fatehpur",
                "Varanasi"
        );
        for(String address: addresses){
            if(s.toUpperCase(Locale.ROOT).equals(address)){return true;}}
        return false;
    }
}

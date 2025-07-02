package com.rishant.Enterprise.Management.System.DataValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.*;

public class SchoolNameValidator implements ConstraintValidator<SchoolNameValidation, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        Set<String> nameHash = new HashSet<String>();

        nameHash.add("MAHARISHI");
        nameHash.add("CHILDREN PUBLIC");
        nameHash.add("SCHOOL OF EXCELLENCE");
        nameHash.add("KENDRIYA VIDYALAYA");
        nameHash.add("DAV PUBLIC SCHOOL");
        nameHash.add("ST. XAVIER'S SCHOOL");
        nameHash.add("DELHI PUBLIC SCHOOL");
        nameHash.add("ST. MARY'S SCHOOL");
        nameHash.add("ST. JOSEPH'S SCHOOL");
       if(nameHash.contains(s.toUpperCase(Locale.ROOT))) return true;
        return false;
    }
}

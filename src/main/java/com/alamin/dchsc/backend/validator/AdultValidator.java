package com.alamin.dchsc.backend.validator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;

public class AdultValidator implements Predicate<String> {
    @Override
    public boolean test(String dob) {
        return Period.between(LocalDate.parse(dob), LocalDate.now()).getYears()>8;
    }
}

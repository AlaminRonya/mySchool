package com.alamin.dchsc.backend.validator;

import java.util.function.Predicate;

public class PhoneNumberValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return (s.startsWith("01") && (s.length() == 11)) || (s.startsWith("+8801") && (s.length() == 14));
    }
}

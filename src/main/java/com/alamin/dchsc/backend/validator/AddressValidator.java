package com.alamin.dchsc.backend.validator;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressValidator implements Predicate<String> {
    private final Pattern VALID_NAME_REGEX = Pattern.compile("^[a-zA-Z0-9_'.']*$");

    @Override
    public boolean test(String s) {
//        TODO: Regex to validate name
        Matcher matcher = VALID_NAME_REGEX.matcher(s);
        return matcher.find();
    }
}

package com.alamin.dchsc.backend.validator;

import com.alamin.dchsc.backend.dto.RequestStudentDto;

import java.util.function.Function;

public interface AppUserRegistrationValidator extends Function<RequestStudentDto, AppUserRegistrationValidator.ValidationResult> {

    static AppUserRegistrationValidator isEmail(){
        return request -> new EmailValidator().test(request.getEmail()) ? ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }

    static AppUserRegistrationValidator isPhoneNumberValid(){
        return request -> new PhoneNumberValidator().test(request.getPhoneNumber()) ? ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    default AppUserRegistrationValidator and(AppUserRegistrationValidator other){
        return appUser -> {
            ValidationResult result = this.apply(appUser);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(appUser) : result;
        };
    }
    enum ValidationResult{
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT,
        NID_NOT_VALID,
        ACCOUNT_NUMBER_NOT_VALID,
        NAME_NOT_VALID,
        PASSWORD_NOT_VALID
    }
}

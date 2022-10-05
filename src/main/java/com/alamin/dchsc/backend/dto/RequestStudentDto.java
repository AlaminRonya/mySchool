package com.alamin.dchsc.backend.dto;

import com.alamin.dchsc.backend.ClassName;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class RequestStudentDto {

    private String fullName;
    private String phoneNumber;
    private String fatherName;
    private String motherName;
    private String presentAddress;
    private String permanentAddress;
    private String district;
    private String religion;
    private String email;
    private String radioGroup;
    private LocalDate dateOfBirth;
    private ClassName className;

}

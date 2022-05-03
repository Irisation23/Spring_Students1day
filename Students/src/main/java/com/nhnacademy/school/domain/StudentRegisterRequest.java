package com.nhnacademy.school.domain;

import lombok.Value;

import javax.validation.constraints.*;

@Value
public class StudentRegisterRequest {
    @NotBlank
    String name;
    @Email
    String email;
    @Min(0) @Max(100)
    int score;
    @NotBlank @Size(max = 300)
    String comment;
}

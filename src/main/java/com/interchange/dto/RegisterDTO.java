package com.interchange.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.Period;

@Data
public class RegisterDTO {
    @Length(max = 10, message = "The User ID must be less than 10 characters")
    @NotBlank(message = "The User ID can not null")
    private String userId;
    @NotBlank(message = "The password can not null")
    private String password;
    @NotBlank(message = "The re password can not null")
    private String rePassword;
    @NotBlank(message = "The phone number can not null")
    @Pattern(regexp = "^\\+[1-9]\\d{1,14}$", message = "Invalid phone number")
    private String phoneNumber;
    @NotBlank(message = "The email can not null")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "The first name can not null")
    private String firstName;
    @NotBlank(message = "The last name can not null")
    private String lastName;
    @NotBlank(message = "The birth date can not null")
    private String birthDate;
    @NotBlank(message = "The province can not null")
    private String province;
    @NotBlank(message = "The district can not null")
    private String district;
    @NotBlank(message = "The ward can not null")
    private String ward;
    @NotBlank(message = "The Street Address can not null")
    private String streetAddress;
    //    @NotBlank(message = "The OTP can not null")
    private String otp;

    public boolean isOver18() {
        if (birthDate == null || birthDate.isEmpty()) {
            return false;
        }
        try {
            LocalDate birthdateObj = LocalDate.parse(birthDate);

            LocalDate currentDate = LocalDate.now();
            Period age = Period.between(birthdateObj, currentDate);

            return age.getYears() >= 18;
        } catch (Exception ex) {
            return false;
        }
    }
}
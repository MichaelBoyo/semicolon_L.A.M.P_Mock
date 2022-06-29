package com.example.semicolonlamp.dtos.requests;

import com.example.semicolonlamp.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NativeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String age;
    private Gender gender;


    public NativeRequest(String firstName, String lastName, String email, String phone, String age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }
}

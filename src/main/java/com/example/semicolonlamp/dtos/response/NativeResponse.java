package com.example.semicolonlamp.dtos.response;

import com.example.semicolonlamp.models.Cohort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NativeResponse {
    private String name;
    private String email;
    private String phoneNumber;
    private Cohort cohort;
}

package com.example.semicolonlamp.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

public class Cohort {
    private String id;
    private String cohortNumber;
    private Cohort cohort;
    @DBRef
    private final Native[]natives = new Native[30];
}

package com.example.semicolonlamp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document
@NoArgsConstructor
public class Cohort {
    @Id
    private String id;
    private String cohortNumber;
    private String cohortName;
    @DBRef
    private ArrayList<Native>natives = new ArrayList<>(30);

    public Cohort(String cohortNumber, String cohortName) {
        this.cohortNumber = cohortNumber;
        this.cohortName = cohortName;
    }
}

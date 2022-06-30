package com.example.semicolonlamp.models;

import com.example.semicolonlamp.enums.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Native {
    @Id
    private String id;
    private String nativeID;
    private String firstName;
    private String lastName;

    public Native(String nativeID, String firstName, String lastName, String email, String phone, String age) {
        this.nativeID = nativeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    private String email;
    private String phone;
    private String age;
    private Gender gender;
    private String cohortName;
    private MaritalStatus maritalStatus;
    private String nationality;
    private String stateOfOrigin;
    private String countryOfResidence;
    private String stateOfResidence;
    private YesNo ableToCommit;
    private YesNo ableToRelocate;
    private EmploymentStatus status;
    private NyscStatus nyscStatus;
    private String alternateContact;
    private String whatsappNo;
    private String twitterUserName;
    private String instagram;
    private String gitHub;
    private String linkedIn;
    private String tikTok;
    private String facebookUserName;
    private String telegramNo;
}

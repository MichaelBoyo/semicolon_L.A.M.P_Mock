package com.example.semicolonlamp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Data
@Document
@NoArgsConstructor
public class SemicolonPortal {
    @Id
    private String id;
    private String organizationNo;
    private String name;
    private String password;
    @DBRef
    private List<Native> natives = new ArrayList<>();

    public SemicolonPortal(String organizationNo, String name, String password) {
        this.organizationNo = organizationNo;
        this.name = name;
        this.password = password;
    }
}

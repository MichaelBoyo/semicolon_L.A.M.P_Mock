package com.example.semicolonlamp.models;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ancestors extends Native{
    private int loanAmount = 3_650_000;
    private boolean isOnLoan;
}

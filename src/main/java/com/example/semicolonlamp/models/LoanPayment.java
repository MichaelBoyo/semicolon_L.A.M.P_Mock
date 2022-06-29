package com.example.semicolonlamp.models;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
@AllArgsConstructor
public class LoanPayment {
    @Id
    private String id;
    private String paymentNo;
    private String amount;
    private LocalDateTime paymentDate;

}

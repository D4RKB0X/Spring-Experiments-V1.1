package com.WC3.Bank_Of_Lodaeron.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType inputType;

    @Min(value = 0, message = "Amount cannot be negative!")
    private double amount;
    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Transaction() {}
    public Transaction(TransactionType inputType, double amount, Account account) {
        this.inputType = inputType;
        this.amount = amount;
        this.account = account;
        this.timeStamp = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public TransactionType getInputType() { return inputType; }
    public double getAmount() { return amount; }
    public LocalDateTime getTimeStamp() { return timeStamp; }
    public Account getInputAcc() { return account; }
}
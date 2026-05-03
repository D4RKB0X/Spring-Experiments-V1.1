package com.WC3.Bank_Of_Lodaeron.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double balance;

    public Account() {}
    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Long getID() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    public void setID(Long ID) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setBalance(double balance) { this.balance = balance; }
}
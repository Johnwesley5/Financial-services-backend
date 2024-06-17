package com.financialServices.frauddetection.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FraudDetection {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String accountNumber;

    private int pinCount;

    public FraudDetection() {
    }

    public FraudDetection(int id, String accountNumber, int pinCount) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.pinCount = pinCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinCount() {
        return pinCount;
    }

    public void setPinCount(int pinCount) {
        this.pinCount = pinCount;
    }

    @Override
    public String toString() {
        return "FraudDetection [id=" + id + ", accountNumber=" + accountNumber + ", pinCount=" + pinCount + "]";
    }

    

    
}

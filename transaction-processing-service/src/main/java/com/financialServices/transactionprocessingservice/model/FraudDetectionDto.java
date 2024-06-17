package com.financialServices.transactionprocessingservice.model;

public class FraudDetectionDto {
    
    private String accountNumber;

    private int pinCount;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getpinCount() {
        return pinCount;
    }

    public void setpinCount(int pinCount) {
        this.pinCount = pinCount;
    }

    
}

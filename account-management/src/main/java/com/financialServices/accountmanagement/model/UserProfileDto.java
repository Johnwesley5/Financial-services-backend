package com.financialServices.accountmanagement.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

public class UserProfileDto {
    private String name;
    private String email;
    private String address;

    private String accountNumber;

    private String securityPin;

    private BigDecimal balance;

    private AccountStatus status;



    public UserProfileDto(String name, String email, String address, String accountNumber, String securityPin, BigDecimal balance, AccountStatus status) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.accountNumber = accountNumber;
        this.securityPin = securityPin;
        this.balance = balance;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getSecurityPin() {
        return securityPin;
    }

    public void setSecurityPin(String securityPin) {
        this.securityPin = securityPin;
    }
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public AccountStatus getStatus() {
        return status;

    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}

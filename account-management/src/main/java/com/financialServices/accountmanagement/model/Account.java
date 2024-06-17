package com.financialServices.accountmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    private String accountNumber;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Security pin is required")
    @Size(min = 4, max = 6, message = "Security pin must be between 4 and 6 characters")
    private String securityPin;


    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    private String panNumber;

    private String aadhaarNumber;

    public Account() {
    }

    public Account(Long id, String name, String email, String accountNumber, String address, String securityPin, BigDecimal balance, AccountStatus status, String panNumber, String aadhaarNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accountNumber = accountNumber;
        this.address = address;
        this.securityPin = securityPin;
        this.balance = balance;
        this.status = status;
        this.panNumber = panNumber;
        this.aadhaarNumber = aadhaarNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }
}

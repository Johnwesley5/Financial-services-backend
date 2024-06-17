package com.financialServices.complianceservice.model;

import java.math.BigDecimal;

public class AccountDto {

    private int id;
    private String name;
    private String email;
    private String accountNumber;
    private String address;
    private String securityPin;
    private BigDecimal balance;
    private AccountStatusEnum status;
    private String panNumber;
    private String aadhaarNumber;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
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
    public AccountStatusEnum getStatus() {
        return status;
    }
    public void setStatus(AccountStatusEnum status) {
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

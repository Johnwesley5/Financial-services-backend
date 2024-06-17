package com.financialServices.transactionprocessingservice.model;

import java.math.BigDecimal;

public class AccountDto {
    
  
    private String name;
    private String email;
    private String accountNumber;
    private String address;
    private String securityPin;
    private AccountStatus status;

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
    public AccountStatus getStatus() {
        return status;
    }
    public void setStatus(AccountStatus status) {
        this.status = status;
    }
 
}

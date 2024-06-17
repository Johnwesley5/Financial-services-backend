package com.financialServices.accountmanagement.model;

public class AccountStatusResponse {
    private String accountNumber;
    private AccountStatus status;

    public AccountStatusResponse(String accountNumber, AccountStatus status) {
        this.accountNumber = accountNumber;
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}

package com.financialServices.transactionprocessingservice.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Deposit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String depositId;

    private String accountNumber;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "balance")
    private BigDecimal balance;

    public Deposit() {
    }
    

    public Deposit(String depositId, String accountNumber, BigDecimal amount, BigDecimal balance) {
        this.depositId = depositId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.balance = balance;
    }


    public String getDepositId() {
        return depositId;
    }

    public void setDepositId(String depositId) {
        this.depositId = depositId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Deposit [depositId=" + depositId + ", accountNumber=" + accountNumber + ", amount=" + amount
                + ", balance=" + balance + "]";
    }

    

}

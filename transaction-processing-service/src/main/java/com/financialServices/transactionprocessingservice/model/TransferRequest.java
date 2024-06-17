package com.financialServices.transactionprocessingservice.model;

import java.math.BigDecimal;

public class TransferRequest {
    private BigDecimal amount;
    private String senderAccountNumber;
    private String senderSecurityPin;
    private String receiverAccountNumber;
    private String description;

    public TransferRequest() {
    }

    public TransferRequest(BigDecimal amount, String senderAccountNumber, String senderSecurityPin, String receiverAccountNumber, String description) {
        this.amount = amount;
        this.senderAccountNumber = senderAccountNumber;
        this.senderSecurityPin = senderSecurityPin;
        this.receiverAccountNumber = receiverAccountNumber;
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public String getSenderSecurityPin() {
        return senderSecurityPin;
    }

    public void setSenderSecurityPin(String senderSecurityPin) {
        this.senderSecurityPin = senderSecurityPin;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


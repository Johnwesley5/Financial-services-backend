package com.financialServices.transactionprocessingservice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "sender_account_number")
    private String senderAccountNumber;

    @Column(name = "receiver_account_number")
    private String receiverAccountNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;


    
    public Transaction() {
    }
    
    

    public Transaction(Long id, BigDecimal amount, LocalDateTime timestamp, String senderAccountNumber,
            String receiverAccountNumber, String description, String status, String accountNumber, String securityPin) {
        this.id = id;
        this.amount = amount;
        this.timestamp = timestamp;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.description = description;
        this.status = status;
       
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }
    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "Transaction [id=" + id + ", amount=" + amount + ", timestamp=" + timestamp + ", senderAccountNumber="
                + senderAccountNumber + ", receiverAccountNumber=" + receiverAccountNumber + ", description="
                + description + ", status=" + status + "]";
    }
    


    

    
    
}

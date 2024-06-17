package com.financialServices.transactionprocessingservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financialServices.transactionprocessingservice.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    List<Transaction> findBySenderAccountNumberOrReceiverAccountNumber(String senderAccountNumber, String receiverAccountNumber);
    List<Transaction> findByTimestampBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
}

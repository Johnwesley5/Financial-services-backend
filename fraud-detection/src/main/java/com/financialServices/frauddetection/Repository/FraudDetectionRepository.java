package com.financialServices.frauddetection.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financialServices.frauddetection.Model.FraudDetection;

public interface FraudDetectionRepository extends JpaRepository<FraudDetection, String> {
    boolean existsByAccountNumber(String accountNumber);
    FraudDetection findByAccountNumber(String accountNumber);
}

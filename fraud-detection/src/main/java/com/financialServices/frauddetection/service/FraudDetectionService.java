package com.financialServices.frauddetection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financialServices.frauddetection.Model.FraudDetection;
import com.financialServices.frauddetection.Repository.FraudDetectionRepository;

@Service
public class FraudDetectionService {
    @Autowired
    private FraudDetectionRepository fraudDetectionRepository;

    public boolean checkExistence(String accountNumber) {
        return fraudDetectionRepository.existsByAccountNumber(accountNumber);
    }

    public int getPinCount(String accountNumber) {
        // Retrieve the FraudDetection entity from the repository using the account number
        FraudDetection fraudDetection = fraudDetectionRepository.findByAccountNumber(accountNumber);
        
        // If the entity is found, return the pinCount; otherwise, return 0
        return fraudDetection != null ? fraudDetection.getPinCount() : 0;
    }

    public void incrementPinCount(String accountNumber) {
        FraudDetection fraudDetection = fraudDetectionRepository.findByAccountNumber(accountNumber);
        if (fraudDetection != null) {
            fraudDetection.setPinCount(2);
            fraudDetectionRepository.save(fraudDetection);
        }
    }
    public void saveFraudDetection(String accountNumber) {
        
        FraudDetection fraudDetection = new FraudDetection();
        fraudDetection.setAccountNumber(accountNumber);
        fraudDetection.setPinCount(1); 
        fraudDetectionRepository.save(fraudDetection);
    }

    

}

package com.financialServices.frauddetection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financialServices.frauddetection.Model.FraudDetection;
import com.financialServices.frauddetection.service.FraudDetectionService;

@RestController
@RequestMapping("/fraud-detection")
public class FraudDetectionController {

    @Autowired
    private FraudDetectionService fraudDetectionService;

    @GetMapping("/checkExistence/{accountNumber}")
    public boolean checkExistence(@PathVariable String accountNumber) {
        return fraudDetectionService.checkExistence(accountNumber);
    }

    @GetMapping("/getPinCount/{accountNumber}")
    public int getPinCount(@PathVariable String accountNumber) {
        return fraudDetectionService.getPinCount(accountNumber);
    }

    @PutMapping("/incrementPinCount/{accountNumber}")
    public void incrementPinCount(@PathVariable String accountNumber) {
    fraudDetectionService.incrementPinCount(accountNumber);
}
@PostMapping("/fraud-detection/{accountNumber}")
public void saveFraudDetection(@PathVariable String accountNumber) {
    fraudDetectionService.saveFraudDetection(accountNumber);
}

}

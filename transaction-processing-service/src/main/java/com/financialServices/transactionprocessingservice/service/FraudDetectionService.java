package com.financialServices.transactionprocessingservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.financialServices.transactionprocessingservice.model.FraudDetectionDto;

@FeignClient(name="fraud-detection-service", url="http://localhost:8003")
public interface FraudDetectionService {
    @GetMapping("/fraud-detection/checkExistence/{accountNumber}")
    public boolean checkExistence(@PathVariable String accountNumber);

    @GetMapping("/fraud-detection/getPinCount/{accountNumber}")
    public int getPinCount(@PathVariable String accountNumber);

    @PutMapping("/fraud-detection/incrementPinCount/{accountNumber}")
    public void incrementPinCount(@PathVariable String accountNumber);

    @PostMapping("/fraud-detection")
    public void saveFraudDetection(@RequestBody FraudDetectionDto fraudDetectionDto);


}

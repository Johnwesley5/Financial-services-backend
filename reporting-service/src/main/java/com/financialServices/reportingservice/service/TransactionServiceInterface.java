package com.financialServices.reportingservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.financialServices.reportingservice.model.TransactionDto;

@FeignClient(name="transaction-processing-service", url="http://localhost:8002")
public interface TransactionServiceInterface {
    @GetMapping("/Transactions/weeklyReport")
    List<TransactionDto> generateWeeklyReport();
}

package com.financialServices.reportingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financialServices.reportingservice.model.TransactionDto;
import com.financialServices.reportingservice.service.ReportingService;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportingController {

    private final ReportingService reportingService;

    @Autowired
    public ReportingController(ReportingService reportingService) {
        this.reportingService = reportingService;
    }

    @GetMapping("/weeklyTransactionReport")
    public ResponseEntity<List<TransactionDto>> generateWeeklyTransactionReport() {
        List<TransactionDto> weeklyReport = reportingService.generateWeeklyTransactionReport();
        return ResponseEntity.ok(weeklyReport);
    }
}

package com.financialServices.reportingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.financialServices.reportingservice.model.TransactionDto;
import com.financialServices.reportingservice.service.TransactionServiceInterface;

@Service
public class ReportingService {

    private final TransactionServiceInterface transactionServiceInterface;

    @Autowired
    public ReportingService(TransactionServiceInterface transactionServiceInterface) {
        this.transactionServiceInterface = transactionServiceInterface;
    }

    public List<TransactionDto> generateWeeklyTransactionReport() {
        return transactionServiceInterface.generateWeeklyReport();
    }
}


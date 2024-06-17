package com.financialServices.transactionprocessingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financialServices.transactionprocessingservice.model.Deposit;
import com.financialServices.transactionprocessingservice.model.DepositRequest;
import com.financialServices.transactionprocessingservice.model.Transaction;
import com.financialServices.transactionprocessingservice.model.TransferRequest;
import com.financialServices.transactionprocessingservice.service.AccountService;
import com.financialServices.transactionprocessingservice.service.TransactionService;

@RestController
@RequestMapping("Transactions")
public class TransactionController {
    
    private final AccountService accountService;
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit")
    public Deposit deposit(@RequestBody DepositRequest depositRequest) {
        
        if (!accountService.isValidAccount(depositRequest.getAccountNumber())) {
            throw new IllegalArgumentException("Invalid account number");
        }
        return transactionService.deposit(depositRequest);
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transferAmount(@RequestBody TransferRequest transferRequest) {
        Transaction transaction = transactionService.transfer(transferRequest);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @GetMapping("/transactionDetails/{accountNumber}")
    public ResponseEntity<List<Transaction>> getTransactionsByAccountNumber(@PathVariable String accountNumber) {
        List<Transaction> transactions = transactionService.getTransactionsByAccountNumber(accountNumber);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/weeklyReport")
    public ResponseEntity<List<Transaction>> getWeeklyTransactionReport() {
        List<Transaction> weeklyReport = transactionService.generateWeeklyReport();
        return ResponseEntity.ok(weeklyReport);
    }
}

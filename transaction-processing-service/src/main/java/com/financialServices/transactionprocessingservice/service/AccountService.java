package com.financialServices.transactionprocessingservice.service;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.financialServices.transactionprocessingservice.model.AccountDto;
import com.financialServices.transactionprocessingservice.model.AccountStatus;
import com.financialServices.transactionprocessingservice.model.Transaction;
import com.financialServices.transactionprocessingservice.model.TransferRequest;

@FeignClient(name="account-management-service", url="http://localhost:8001")
public interface AccountService {
    
    @GetMapping("/accounts/accountdetails")
    public AccountDto getAccountDetailsByAccountNumber(@PathVariable String accountNumber);

    @GetMapping("/accounts/validate/{accountNumber}")
    public boolean isValidAccount(@PathVariable String accountNumber);

    @GetMapping("/accounts/balance/{accountNumber}")
    public BigDecimal getAccountBalance(@PathVariable String accountNumber);

    @PutMapping("/accounts/updateBalance/{accountNumber}")
    public void updateAccountBalance(@PathVariable String accountNumber, @RequestParam BigDecimal newBalance);

    @GetMapping("/accounts/validatePin")
    public boolean isValidSecurityPin(@RequestParam String accountNumber, @RequestParam String securityPin);

    @PutMapping("/accounts/transfer")
    public Transaction transferAmount(@RequestBody TransferRequest transferRequest); 

    @PutMapping("/accounts/status")
    public void updateAccountStatus(@RequestParam String accountNumber, @RequestParam AccountStatus status);
}
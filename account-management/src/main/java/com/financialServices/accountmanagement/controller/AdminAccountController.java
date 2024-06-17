package com.financialServices.accountmanagement.controller;

import com.financialServices.accountmanagement.model.Account;
import com.financialServices.accountmanagement.model.AccountStatus;
import com.financialServices.accountmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AdminAccountController {
    @Autowired
    private AccountService accountService;

    @PutMapping("/{accountId}/status")
    public ResponseEntity<String> changeAccountStatus(@PathVariable Long accountId, @RequestBody Map<String, String> requestBody) {
        String status = requestBody.get("status");
        accountService.changeAccountStatus(accountId, AccountStatus.valueOf(status));
        return ResponseEntity.ok("Account status updated successfully");
    }
}

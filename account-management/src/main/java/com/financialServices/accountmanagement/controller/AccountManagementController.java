package com.financialServices.accountmanagement.controller;

import com.financialServices.accountmanagement.model.*;
import com.financialServices.accountmanagement.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountManagementController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody AccountRequestDto accountRequestDto) {
        Account createdAccount = accountService.createAccount(accountRequestDto);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }


    @PostMapping("/status")
    public ResponseEntity<AccountStatusResponse> getAccountStatusByEmail(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        AccountStatusResponse accountStatusResponse = accountService.getAccountStatusByEmail(email);
        return ResponseEntity.ok(accountStatusResponse);
    }

    @PostMapping("/accountdetails")
    public ResponseEntity<UserProfileDto> getAccountDetailsByAccountNumber(@RequestBody Map<String, String> requestBody) {
        String accountNumber = requestBody.get("accountNumber");
        UserProfileDto userProfileDto = accountService.getAccountDetailsByAccountNumber(accountNumber);
        return ResponseEntity.ok(userProfileDto);
    }
    @PutMapping("/updateprofile")
    public ResponseEntity<String> updateProfileDetails(@RequestBody UpdateProfileRequest request) {
        String message = accountService.updateProfileDetails(request);
        return ResponseEntity.ok(message);
    }


    @GetMapping("/validate/{accountNumber}")
    public ResponseEntity<Boolean> isValidAccount(@PathVariable String accountNumber) {
        boolean isValid = accountService.isValidAccount(accountNumber);
        return ResponseEntity.ok(isValid);
    }

    @GetMapping("/balance/{accountNumber}")
    public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable String accountNumber) {
        BigDecimal balance = accountService.getAccountBalance(accountNumber);
        return ResponseEntity.ok(balance);
    }

    @PutMapping("/updateBalance/{accountNumber}")
    public ResponseEntity<Void> updateAccountBalance(@PathVariable String accountNumber, @RequestParam BigDecimal newBalance) {
        accountService.updateAccountBalance(accountNumber, newBalance);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/pin/{accountNumber}")
    public ResponseEntity<String> getSecurityPinByAccountNumber(@PathVariable String accountNumber) {
        String securityPin = accountService.getSecurityPinByAccountNumber(accountNumber);
        return ResponseEntity.ok(securityPin);
    }
    @PutMapping("/status/{accountId}")
    public ResponseEntity<Void> updateAccountStatus(@PathVariable Long accountId, @RequestParam AccountStatus newStatus) {
        accountService.updateAccountStatus(accountId, newStatus);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/kycCompleted")
    public ResponseEntity<List<Account>> getKYCCompletedAccounts() {
        List<Account> kycCompletedAccounts = accountService.getKYCCompletedAccounts();
        return ResponseEntity.ok(kycCompletedAccounts);
    }

    @GetMapping("/kycRequired")
    public ResponseEntity<List<Account>> getKYCRequiredAccounts() {
        List<Account> kycRequiredAccounts = accountService.getKYCRequiredAccounts();
        return ResponseEntity.ok(kycRequiredAccounts);
    }
}

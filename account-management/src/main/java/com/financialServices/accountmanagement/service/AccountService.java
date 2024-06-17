package com.financialServices.accountmanagement.service;

import com.financialServices.accountmanagement.model.*;
import com.financialServices.accountmanagement.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;



    @Transactional
    public Account createAccount(AccountRequestDto accountRequestDto) {
        Account account = new Account();
        account.setName(accountRequestDto.getName());
        account.setEmail(accountRequestDto.getEmail());
        account.setAddress(accountRequestDto.getAddress());
        account.setSecurityPin(accountRequestDto.getSecurityPin());
        account.setStatus(AccountStatus.PENDING);
        String accountNumber = generateAccountNumber();
        account.setAccountNumber(accountNumber);
        return accountRepository.save(account);
    }


    private String generateAccountNumber() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 12);
    }


    @Transactional(readOnly = true)
    public boolean isValidAccount(String accountNumber) {
        return accountRepository.existsByAccountNumber(accountNumber);
    }

    @Transactional(readOnly = true)
    public BigDecimal getAccountBalance(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with account number: " + accountNumber));
        return account.getBalance();
    }

    @Transactional
    public void updateAccountBalance(String accountNumber, BigDecimal newBalance) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with account number: " + accountNumber));
        account.setBalance(newBalance);
        accountRepository.save(account);
    }

    @Transactional
    public void changeAccountStatus(Long accountId, AccountStatus status) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setStatus(status);
            accountRepository.save(account);
        } else {
            throw new EntityNotFoundException("Account not found with id: " + accountId);
        }
    }

    @Transactional(readOnly = true)
    public AccountStatusResponse getAccountStatusByEmail(String email) {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with email: " + email));
        return new AccountStatusResponse(account.getAccountNumber(), account.getStatus());
    }
    @Transactional(readOnly = true)
    public UserProfileDto getAccountDetailsByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with account number: " + accountNumber));
        return new UserProfileDto(account.getName(), account.getEmail(), account.getAddress(), account.getAccountNumber(), account.getSecurityPin(), account.getBalance(), account.getStatus());
    }
    @Transactional
    public String updateProfileDetails(UpdateProfileRequest request) {
        Account account = accountRepository.findByAccountNumber(request.getAccountNumber())
                .orElseThrow(() -> new EntityNotFoundException("Account not found with account number: " + request.getAccountNumber()));


        if (!account.getSecurityPin().equals(request.getPreviousPin())) {
            throw new IllegalArgumentException("Previous pin does not match");
        }

        if (request.getName() != null) {
            account.setName(request.getName());
        }
        if (request.getEmail() != null) {
            account.setEmail(request.getEmail());
        }
        if (request.getAddress() != null) {
            account.setAddress(request.getAddress());
        }
        if (request.getNewPin() != null) {
            account.setSecurityPin(request.getNewPin());
        }
        if (request.getPanNumber() != null) {
            account.setPanNumber(request.getPanNumber());
        }
        if (request.getAadhaarNumber() != null) {
            account.setAadhaarNumber(request.getAadhaarNumber());
        }

        accountRepository.save(account);
        return "Profile details updated successfully";
    }

    @Transactional(readOnly = true)
    public String getSecurityPinByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with account number: " + accountNumber));
        return account.getSecurityPin();
    }
    @Transactional
    public void updateAccountStatus(Long accountId, AccountStatus newStatus) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setStatus(newStatus);
            accountRepository.save(account);
        } else {
            throw new EntityNotFoundException("Account not found with id: " + accountId);
        }
    }
    @Transactional(readOnly = true)
    public List<Account> getKYCCompletedAccounts() {
        return accountRepository.findByAadhaarNumberIsNotNullAndPanNumberIsNotNull();
    }

    @Transactional(readOnly = true)
    public List<Account> getKYCRequiredAccounts() {
        return accountRepository.findByAadhaarNumberIsNullAndPanNumberIsNull();
    }

}

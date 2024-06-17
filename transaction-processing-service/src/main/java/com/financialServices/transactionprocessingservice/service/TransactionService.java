package com.financialServices.transactionprocessingservice.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financialServices.transactionprocessingservice.model.AccountDto;
import com.financialServices.transactionprocessingservice.model.AccountStatus;
import com.financialServices.transactionprocessingservice.model.Deposit;
import com.financialServices.transactionprocessingservice.model.DepositRequest;
import com.financialServices.transactionprocessingservice.model.FraudDetectionDto;
import com.financialServices.transactionprocessingservice.model.Transaction;
import com.financialServices.transactionprocessingservice.model.TransferRequest;
import com.financialServices.transactionprocessingservice.repository.TransactionRepository;

@Service
public class TransactionService {

    private final AccountService accountService;

    @Autowired
    private FraudDetectionService fraudDetectionService;


    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Deposit deposit(DepositRequest depositRequest) {
        
        if (!accountService.isValidAccount(depositRequest.getAccountNumber())) {
            throw new IllegalArgumentException("Invalid account number");
        }

        
        BigDecimal currentBalance = accountService.getAccountBalance(depositRequest.getAccountNumber());

        
        BigDecimal newBalance = currentBalance.add(depositRequest.getAmount());

        
        accountService.updateAccountBalance(depositRequest.getAccountNumber(), newBalance);

        
        Deposit deposit = new Deposit();
        deposit.setAccountNumber(depositRequest.getAccountNumber());
        deposit.setAmount(depositRequest.getAmount());
        deposit.setBalance(newBalance);
        return deposit;
    }
    
    public Transaction transfer(TransferRequest transferRequest) {

        AccountDto senderAccount = accountService.getAccountDetailsByAccountNumber(transferRequest.getSenderAccountNumber());
        
        if (senderAccount == null || senderAccount.getStatus() != AccountStatus.APPROVED) {
            throw new IllegalArgumentException("Sender account is not approved or does not exist");
        }
        if (senderAccount == null || !senderAccount.getSecurityPin().equals(transferRequest.getSenderSecurityPin())) {
        boolean accountExistsInFraudDetection = fraudDetectionService.checkExistence(transferRequest.getSenderAccountNumber());
        if (accountExistsInFraudDetection) {
            int pinCount = fraudDetectionService.getPinCount(transferRequest.getSenderAccountNumber());
    if (pinCount == 1) {
        fraudDetectionService.incrementPinCount(transferRequest.getSenderAccountNumber());
    } else {
        accountService.updateAccountStatus(transferRequest.getSenderAccountNumber(), AccountStatus.BLACKLISTED);
    }
        } 
        else {
            FraudDetectionDto fraudDetectionDto = new FraudDetectionDto();
            fraudDetectionDto.setAccountNumber(transferRequest.getSenderAccountNumber());
            fraudDetectionDto.setpinCount(1);
            fraudDetectionService.saveFraudDetection(fraudDetectionDto);
        }
        
        
        
        throw new IllegalArgumentException("Invalid sender account number or pin");
    }
    

        Transaction transaction = new Transaction();
        transaction.setAmount(transferRequest.getAmount());
        transaction.setSenderAccountNumber(transferRequest.getSenderAccountNumber());
        transaction.setReceiverAccountNumber(transferRequest.getReceiverAccountNumber());
        transaction.setDescription(transferRequest.getDescription());
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setStatus("Pending");

        transactionRepository.save(transaction);
    
        performTransaction(transferRequest);
        transaction.setStatus("Success");
        transactionRepository.save(transaction);
    
        return transaction;
    }
    
    
private void performTransaction(TransferRequest transferRequest) {
    
    accountService.updateAccountBalance(transferRequest.getSenderAccountNumber(),
                                         accountService.getAccountBalance(transferRequest.getSenderAccountNumber())
                                         .subtract(transferRequest.getAmount()));

    
    accountService.updateAccountBalance(transferRequest.getReceiverAccountNumber(),
                                         accountService.getAccountBalance(transferRequest.getReceiverAccountNumber())
                                         .add(transferRequest.getAmount()));
}

    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) {
        return transactionRepository.findBySenderAccountNumberOrReceiverAccountNumber(accountNumber, accountNumber);
    }  
    
    public List<Transaction> generateWeeklyReport() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneWeekAgo = now.minusWeeks(1);
        return transactionRepository.findByTimestampBetween(oneWeekAgo, now);
    }
}

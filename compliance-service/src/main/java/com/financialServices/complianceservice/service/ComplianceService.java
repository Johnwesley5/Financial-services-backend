package com.financialServices.complianceservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financialServices.complianceservice.model.AccountDto;

@Service
public class ComplianceService {

    @Autowired
    private AccountServiceInterface accountServiceInterface;

    public List<AccountDto> getKYCCompletedAccounts() {
        return accountServiceInterface.getKYCCompletedAccounts();
    }

    public List<AccountDto> getKYCRequiredAccounts() {
        return accountServiceInterface.getKYCRequiredAccounts();
    }
}

package com.financialServices.complianceservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financialServices.complianceservice.model.AccountDto;
import com.financialServices.complianceservice.service.AccountServiceInterface;
import com.financialServices.complianceservice.service.ComplianceService;

@RestController
@RequestMapping("/compliance")
public class ComplianceController {
    
    @Autowired
    private ComplianceService complianceService;

    @GetMapping("/kycCompletedAccounts")
    public List<AccountDto> getKYCCompletedAccounts() {
        return complianceService.getKYCCompletedAccounts();
    }

    @GetMapping("/kycRequiredAccounts")
    public List<AccountDto> getKYCRequiredAccounts() {
        return complianceService.getKYCRequiredAccounts();
    }
}

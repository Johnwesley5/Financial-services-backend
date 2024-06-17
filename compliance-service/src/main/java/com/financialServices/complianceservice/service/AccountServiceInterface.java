package com.financialServices.complianceservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.financialServices.complianceservice.model.AccountDto;

@FeignClient(name="account-management-service", url="http://localhost:8001")
public interface AccountServiceInterface {
    
    @GetMapping("/accounts/kycCompleted")
    List<AccountDto> getKYCCompletedAccounts();

    @GetMapping("/accounts/kycRequired")
    List<AccountDto> getKYCRequiredAccounts();
}

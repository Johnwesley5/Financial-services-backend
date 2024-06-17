package com.financialServices.accountmanagement.repository;

import com.financialServices.accountmanagement.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
    Optional<Account> findByAccountNumber(String accountNumber);

    boolean existsByAccountNumber(String accountNumber);

    List<Account> findByAadhaarNumberIsNotNullAndPanNumberIsNotNull();

    List<Account> findByAadhaarNumberIsNullAndPanNumberIsNull();
}

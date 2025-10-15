package com.example.customer_accounts_oracle.repo;

import com.example.customer_accounts_oracle.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

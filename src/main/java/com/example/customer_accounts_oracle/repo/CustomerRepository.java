package com.example.customer_accounts_oracle.repo;

import com.example.customer_accounts_oracle.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByNationalId(String nationalId);
    boolean existsByEmail(String email);
}

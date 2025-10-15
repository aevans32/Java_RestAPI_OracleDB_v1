package com.example.customer_accounts_oracle.service;

import com.example.customer_accounts_oracle.api.dto.Account.AccountResponse;
import com.example.customer_accounts_oracle.api.dto.Account.CreateAccountRequest;
import com.example.customer_accounts_oracle.api.dto.Account.UpdateAccountStatusRequest;
import com.example.customer_accounts_oracle.domain.Account;
import com.example.customer_accounts_oracle.domain.Customer;
import com.example.customer_accounts_oracle.repo.AccountRepository;
import com.example.customer_accounts_oracle.repo.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {

    private final AccountRepository accounts;
    private final CustomerRepository customers;

    public AccountService(AccountRepository accounts, CustomerRepository customers) {
        this.accounts = accounts; this.customers = customers;
    }

    public AccountResponse create(CreateAccountRequest req) {
        Customer owner = customers.findById(req.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        Account a = new Account();
        a.setCustomer(owner);
        a.setType(req.getType());
        a.setCurrency(req.getCurrency());
        a.setStatus("ACTIVE");
        a = accounts.save(a);
        return toResponse(a);
    }

    @Transactional(readOnly=true)
    public List<AccountResponse> list() {
        return accounts.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly=true)
    public AccountResponse get(Long id) {
        return toResponse(accounts.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found")));
    }

    public AccountResponse updateStatus(Long id, UpdateAccountStatusRequest req) {
        Account a = accounts.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found"));
        a.setStatus(req.getStatus());
        return toResponse(a);
    }

    public void delete(Long id) { accounts.deleteById(id); }

    private AccountResponse toResponse(Account a) {
        return new AccountResponse(a.getId(), a.getCustomer().getId(), a.getType(), a.getCurrency(), a.getStatus());
    }
}

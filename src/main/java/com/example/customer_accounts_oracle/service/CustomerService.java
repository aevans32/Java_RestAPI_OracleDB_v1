package com.example.customer_accounts_oracle.service;

import com.example.customer_accounts_oracle.api.dto.Customer.CreateCustomerRequest;
import com.example.customer_accounts_oracle.api.dto.Customer.CustomerResponse;
import com.example.customer_accounts_oracle.api.dto.Customer.UpdateCustomerRequest;
import com.example.customer_accounts_oracle.domain.Customer;
import com.example.customer_accounts_oracle.repo.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) { this.repo = repo; }

    public CustomerResponse create(CreateCustomerRequest req) {

        Customer c = new Customer();
        c.setFullName(req.getFullName());
        c.setNationalId(req.getNationalId());
        c.setEmail(req.getEmail());
        c.setKycStatus("PENDING");

        try {
            c = repo.save(c);
        } catch (DataIntegrityViolationException e) {
            throw e;
        }
        return toResponse(c);
    }

    @Transactional(readOnly=true)
    public List<CustomerResponse> list() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly=true)
    public CustomerResponse get(Long id) {
        return toResponse(find(id));
    }

    public CustomerResponse update(Long id, UpdateCustomerRequest req) {
        Customer c = find(id);
        c.setFullName(req.getFullName());
        c.setEmail(req.getEmail());
        c.setKycStatus(req.getKycStatus());
        return toResponse(c);
    }

    public void delete(Long id) {
        repo.delete(find(id));
    }

    private Customer find(Long id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }

    private CustomerResponse toResponse(Customer c) {
        return new CustomerResponse(c.getId(), c.getFullName(), c.getNationalId(), c.getEmail(), c.getKycStatus());
    }
}

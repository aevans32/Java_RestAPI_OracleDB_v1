package com.example.customer_accounts_oracle.api;

import com.example.customer_accounts_oracle.api.dto.Customer.CreateCustomerRequest;
import com.example.customer_accounts_oracle.api.dto.Customer.CustomerResponse;
import com.example.customer_accounts_oracle.api.dto.Customer.UpdateCustomerRequest;
import com.example.customer_accounts_oracle.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService svc;
    public CustomerController(CustomerService svc) {this.svc = svc;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@Valid @RequestBody CreateCustomerRequest req) {
        return svc.create(req);
    }

    @GetMapping
    public List<CustomerResponse> list() {return svc.list();}

    @GetMapping("/{id}")
    public CustomerResponse get(@PathVariable Long id) { return svc.get(id); }

    @PutMapping("/{id}")
    public CustomerResponse update(@PathVariable Long id, @Valid @RequestBody UpdateCustomerRequest req) {
        return svc.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { svc.delete(id);}
}

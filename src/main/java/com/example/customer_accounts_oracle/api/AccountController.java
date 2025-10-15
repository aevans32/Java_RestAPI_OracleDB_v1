package com.example.customer_accounts_oracle.api;

import com.example.customer_accounts_oracle.api.dto.Account.AccountResponse;
import com.example.customer_accounts_oracle.api.dto.Account.CreateAccountRequest;
import com.example.customer_accounts_oracle.api.dto.Account.UpdateAccountStatusRequest;
import com.example.customer_accounts_oracle.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService svc;

    public AccountController(AccountService svc) { this.svc = svc; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponse create(@Valid @RequestBody CreateAccountRequest req) {
        return svc.create(req);
    }

    @GetMapping
    public List<AccountResponse> list() { return svc.list(); }

    @GetMapping("/{id}")
    public AccountResponse get(@PathVariable Long id) { return svc.get(id); }

    @PatchMapping("/{id}/status")
    public AccountResponse updateStatus(@PathVariable Long id, @Valid @RequestBody UpdateAccountStatusRequest req) {
        return svc.updateStatus(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { svc.delete(id); }
}

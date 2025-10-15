package com.example.customer_accounts_oracle.api.dto.Account;

import jakarta.validation.constraints.*;

public class CreateAccountRequest {
    @NotNull
    private Long customerId;

    @NotBlank
    @Pattern(regexp = "^(SAVINGS|CHECKING)$")
    private String type;

    @NotBlank
    @Pattern(regexp = "^[A-Z]{3}$")
    private String currency;

    // Getters and Setters
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}

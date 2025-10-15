package com.example.customer_accounts_oracle.api.dto.Account;

import jakarta.validation.constraints.*;

public class UpdateAccountStatusRequest {

    @NotBlank
    @Pattern(regexp = "^(ACTIVE|BLOCKED|CLOSED)$")
    private String status;

    // Getters and Setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
